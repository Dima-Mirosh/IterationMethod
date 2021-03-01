package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Initialize of start elements
            Scanner in = new Scanner(System.in);
            double[][] array = {{5, 1, -1, 1}, {1, -4, 1, -1}, {-1, 1, 4, 1}, {1, 2, 1, -5}};
            double module = det(array);
            if(module <= 0){
                System.out.println("Determinant negative or equal to 0");
                return;
            }
            System.out.println("Enter your variant");
            boolean prevalence, check = true;
            double m = in.nextDouble();
            double[] approach = {0.7*m, 1, 2, 0.5};
            double[] b = {3*m, m-6, 15-m, m+2};
            double[] iterationResult = new double[4];
            double[] iterationCheck = new double[4];
            double sum = 0;
            double max = 0;
        //Condition of the prevalence of the method
            System.out.println("Condition of the prevalence of the method");
            for (int i = 0, k = 0; i < array.length; k++, i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (i != j) {
                        sum += Math.abs(array[i][j]);
                    }
                }
                if(sum > Math.abs(array[i][k])){
                    prevalence = false;
                    check = false;
                    System.out.println("Sum absolute of not diagonal elements in " + i + " row is " + sum + "> then " + Math.abs(array[i][k]) + " - " + prevalence);
                }
                else{
                    prevalence = true;
                    System.out.println("Sum absolute of not diagonal elements in " + i + " row is " + sum + "< then " + Math.abs(array[i][k]) + " - " + prevalence);
                }
                sum = 0;
            }
        System.out.println();
            if(check == true){
            //Main cycle of calculation, 9 steps of iteration
            for (int p = 1; p <= 9; p++) {
                for (int i = 0, k = 0; i < array.length; k++, i++) {
                    for (int j = 0; j < array[i].length; j++) {
                        if (i != j) {
                            sum += approach[j]*array[i][j];
                        }
                    }
                    iterationResult[i] = (b[i] - sum) / array[i][k];
                    sum = 0;
                }

                for (int i = 0; i < approach.length; i++) {
                    approach[i] = iterationResult[i];
                }

                for (int i = 0; i < iterationResult.length; i++) {
                    System.out.printf("Result of %d step of %d iteration is %.3f \n", i+1 ,p ,iterationResult[i]);
                }
                System.out.println();
                //Check the accuracy of the calculations as the absolute of difference of the last two results
                if(p >=2){
                    System.out.println("Check the accuracy of the calculations as the absolute of difference of the last two results");
                    max = Math.abs(iterationResult[0]-iterationCheck[0]);
                    double diff = 0;
                    for (int i = 0; i < iterationResult.length; i++) {
                        diff = Math.abs(iterationResult[i]-iterationCheck[i]);
                        System.out.printf("%.3f-%.3f=%.3f\n", iterationResult[i], iterationCheck[i], diff);
                        if(diff > max) max = diff;
                    }
                    System.out.printf("Max absolute of difference between %d iteration and %d iteration is %.3f\n", p-1, p, max);
                }
                for (int i = 0; i < iterationResult.length; i++) {
                    iterationCheck[i] = iterationResult[i];
                }
                System.out.println();
            }
            System.out.print("Answer is: ");
            for (int i = 0; i < iterationResult.length ; i++) {
                System.out.printf("X%d = %.3f; ", i+1, iterationResult[i]);
            }
            sum = 0;
            System.out.println();
            System.out.println();
            //Check of results
            for (int i = 0; i < array.length; i++) {
                System.out.printf("%d equation is ", i+1);
                for (int j = 0; j < array[i].length; j++) {
                    sum = sum + array[i][j]*iterationResult[j];
                    if((array[i].length - j) == 1) {
                        System.out.printf("%.0f*%.3f", array[i][j], approach[j]);
                    }
                    else System.out.printf("%.0f*%.3f + ", array[i][j], approach[j]);
                }
                System.out.printf(" = %.0f and we had %.0f on right side at the start of calculation \n", sum, b[i]);
                sum = 0;
            }
        }
            else System.out.println("The convergence condition is not met");
    }
        //Searching of determinant, useful for any square matrix
    public static double det(double[][] arr){
        double[][] array = new double[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            array[i] = new double[arr.length];
            for (int j = 0; j < arr[i].length; j++) {
                array[i][j] = arr[i][j];
            }
        }
        double module = 1;
        double[] mas = new double[arr.length];
        double[] num = new double[arr.length];
        for (int p = 0; p < array.length-1; p++) {
            double N = array[p][p];
            for (int i = 0; i < array.length; i++) {
                mas[i] = array[p][i] / N;
            }
            for (int i = (p+1); i <= array.length-1; i++) {
                for (int j = 0; j < array.length; j++) {
                    num[j] = array[i][j] - (mas[j] * array[i][p]);
                }
                for (int j = 0; j < array.length; j++) {
                    array[i][j] = num[j];
                }
            }
        }
        for (int i = 0, j = 0; i < array.length;j++, i++) {
                module *= array[i][j];
        }
        System.out.println("Determinant is = " + module);
        return module;
    }
}
