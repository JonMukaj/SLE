import numpy
import os
import random
import sys
from scipy.linalg import lu,lu_factor,lu_solve


# method to randomly generate matrices
def generateMatrix(nr_of_unknowns):
    m = numpy.eye(nr_of_unknowns)
    for i in range(nr_of_unknowns):
        if random.randint(0, 1) == 0:  # for diagonal elements
            m[i, i] = -1
        else:
            m[i, i] = 1

        for j in range(i + 1, nr_of_unknowns):
            m[i, j] = random.randint(-3, 3)

    for j in range(nr_of_unknowns - 1, -1, -1):
        for i in range(j + i, nr_of_unknowns):
            if random.randint(0, 1) == 0:
                m[i] = fillValues(m, i, j, random.randint(-3, 1))
            else:
                m[i] = fillValues(m, i, j, random.randint(1, 4))

    swapValues(m, 0, random.randint(1, nr_of_unknowns - 1))

    n = numpy.zeros((nr_of_unknowns, 1))  # creating B matrix
    for i in range(nr_of_unknowns):
        n[i] = random.randint(-5, 5)
    return m.astype(int),n.astype(int)

# method to fill values
def fillValues(m, i, j, value):
    return m[i] + value * m[j]


# method to randomly swap values
def swapValues(m, i, j):
    m[i] = m[i] + m[j]
    m[j] = m[i] - m[j]
    m[i] = m[i] - m[j]

#find x with LU decomposition
def LUMethod(m,n):
    p, l, u = lu(m)  #returnthe lower and upper matrices divided from each other
    k, pivot = lu_factor(m)  #return LU factor matrix
    x = lu_solve((k,pivot),n)  #return solution to LU factor
    return x, l, u

def normalize_rows(x):
    return x / numpy.linalg.norm(x, ord=2, axis=1, keepdims=True)


def createSLE(nr_of_unknowns):
    if os.path.exists("GeneratedSleMatrix.tex"):
        os.remove("GeneratedSleMatrix.tex")
    infile = open("GeneratedSleMatrix.tex", "a")
    infile.write('\documentclass{article}\n')
    infile.write('\\begin{document}\n')
    infile.write('\\begin{enumerate}\n')
    infile.write('\item \n')

    a, b = generateMatrix(nr_of_unknowns)
    a_norm = normalize_rows(a)
    b_norm = normalize_rows(b)
    x,lower,upper = LUMethod(a,b)

    eigval, eigvec = numpy.linalg.eig(a)

    rank = numpy.linalg.matrix_rank(a)
    cond_number = numpy.linalg.cond(a)
    trace = numpy.trace(a)
    inv_a = numpy.linalg.inv(a)
    det_a = numpy.linalg.det(a)

    print ("\nUnimodular matrix A:")
    print (a)

    print ("\nMatrix B:")
    print (b)

    print ("\nSolution matrix X:")
    print (x)

    print ("\nvalues:")
    print (rank)
    print(cond_number)
    print(trace)
    print(inv_a)
    print(det_a)

    infile.write('$\\begin{array}{')
    for i in range(nr_of_unknowns + 1):
        infile.write('r@{\ }c@{\ }')
    infile.write('}\n')

    print("\nThe system of linear equations is: ")

    for i in range(nr_of_unknowns):
        text = ""
        for j in range(nr_of_unknowns):
            if a[i, j] < 0:
                if j == 0:
                    token = '-'
                else:
                    token = ' -& '

                if a[i, j] == -1:
                    k = ""
                else:
                    k = str(abs(a[i, j]))

                l = k + 'x_{' + str(j + 1) + '}&'

            elif a[i, j] == 0:
                if j == 0:
                    token = ''

                else:
                    token = '&'

                l = '&'
            else:
                if j == 0:
                    token = ''
                else:
                    token = ' +& '

                if a[i, j] == 1:
                    k = ""
                else:
                    k = str(abs(a[i, j]))

                l = k + 'x_{' + str(j + 1) + '}&'

            text = text + token + l

            if j + 1 == nr_of_unknowns:
                text = text + '=&' + str(b[i, 0]) + ' \\\\\n '

        #print (text)
        infile.write(text)

    infile.write('\\end{array}$\n')
    infile.write('\end{enumerate}\n')
    infile.write('\end{document}\n')
    infile.close()

    os.system("pdflatex GeneratedSleMatrix.tex")

    outfile = open("Solution.txt", "w")
    outfile.write("Solution matrix X:\n")
    outfile.write(str(x))
    outfile.close()

    outfile = open("Matrices.txt", "w")
    outfile.write("Generated matrices:\n")
    outfile.write("\nMatrix A\n" + str(a) + "\n" + "\nMatrix B\n" + str(b))
    outfile.close()

    outfile = open("Normalized.txt", "w")
    outfile.write("Normalized Matrix A:\n")
    outfile.write(str(a_norm))
    outfile.write("\n\nNormalized Matrix B:\n")
    outfile.write(str(b_norm))
    outfile.close()

    outfile = open("Eigen.txt", "w")
    outfile.write("Eigenvalues for A:\n")
    outfile.write(str(eigval))
    outfile.write("\n\nEigenvectors for A:\n")
    outfile.write(str(eigvec))
    outfile.close()

    outfile = open("Info.txt", "w")
    outfile.write("Rank of A: ")
    outfile.write(str(rank))
    outfile.write("\n\nDeterminant of A: ")
    outfile.write(str(det_a))
    outfile.write("\n\nTrace of A: ")
    outfile.write(str(trace))
    outfile.write("\n\nCondition number of A: ")
    outfile.write(str(cond_number))
    outfile.write("\n\nLower Triangular Matrix:\n")
    outfile.write(str(lower))
    outfile.write("\n\nUpper Triangular Matrix:\n")
    outfile.write(str(upper))
    outfile.close()

    #os.system("GeneratedSleMatrix.pdf")


numberOfUnknowns = int(sys.argv[1])
createSLE(numberOfUnknowns)
