public class Evaluation {
    private String XO[][]  = new String[3][3];
    private boolean aiFirst = false;

    public Evaluation(String[][] table , boolean af)
    {
        setTable(table);
        aiFirst = af;
    }



    private void setTable (String[][] table)
    {
        for(int i = 0 ; i <= 2 ; i++)
            for(int j = 0 ; j <= 2 ; j++)
                XO[i][j] = table[i][j];
    }



    public int[] chooseEva()
    {
        int evaSet[][] = sumEva();

        int max = 0;
        int imax = 0;
        int jmax = 0;
        int i = 0;
        int j = 0;

        for(i = 0 ; i < 3 ; i++)
        {

            for(j = 0 ; j < 3 ; j++)
            {
                if(evaSet[i][j]>max)
                {
                    max = evaSet[i][j];
                    imax = i;
                    jmax = j;
                }
            }
        }

        int aiChoose[] = new int[2];
        aiChoose[0]=imax;
        aiChoose[1]=jmax;
        System.out.println("AI CHOOSE : " +(imax+1) +" "+(jmax+1));
        return aiChoose;
    }

    private int[][] sumEva()
    {
        int evaSet[][] = new int[3][3];
        for(int i = 0 ; i <= 2 ; i++)
            for(int j = 0 ; j <= 2 ; j++)
            {
                int eva = 0;


                if(aiFirst == true)
                {
                    if(       ( XO[i][0].contains("X")||XO[i][0].contains("-") )   &&
                              ( XO[i][1].contains("X")||XO[i][1].contains("-") )   &&
                              ( XO[i][2].contains("X")||XO[i][2].contains("-") )    )
                        eva++;



                    if(     ( XO[0][j].contains("X")||XO[0][j].contains("-") )   &&
                            ( XO[1][j].contains("X")||XO[1][j].contains("-") )   &&
                            ( XO[2][j].contains("X")||XO[2][j].contains("-") )    )
                        eva++;



                    if(i==j)
                    {
                        if(     ( XO[0][0].contains("X")||XO[0][0].contains("-") )   &&
                                ( XO[1][1].contains("X")||XO[1][1].contains("-") )   &&
                                ( XO[2][2].contains("X")||XO[2][2].contains("-") )    )
                            eva++;
                        else
                            eva--;
                    }
                    if (i+j==2)
                    {
                        if ((XO[2][0].contains("X") || XO[2][0].contains("-")) &&
                                (XO[1][1].contains("X") || XO[1][1].contains("-")) &&
                                (XO[2][0].contains("X") || XO[2][0].contains("-")))
                            eva++;
                        else
                            eva--;
                    }




                    if(XO[i][j].contains("-"))
                        eva+=200;

                    if(XO[i][j].contains("X")||XO[i][j].contains("O"))
                        eva-=200000;


                    int numi = 0;
                    int numj = 0;
                    int numt = 0;

                    if(XO[i][0].contains("X"))
                        numi ++;
                    if(XO[i][1].contains("X"))
                        numi ++;
                    if(XO[i][2].contains("X"))
                        numi ++;

                    if(XO[0][j].contains("X"))
                        numj ++;
                    if(XO[1][j].contains("X"))
                        numj ++;
                    if(XO[2][j].contains("X"))
                        numj ++;

                    if(XO[0][0].contains("X"))
                        numt ++;
                    if(XO[1][1].contains("X"))
                        numt ++;
                    if(XO[2][2].contains("X"))
                        numt ++;

                    if(XO[2][0].contains("X"))
                        numt ++;
                    if(XO[1][1].contains("X"))
                        numt ++;
                    if(XO[0][2].contains("X"))
                        numt ++;

                    if(numi >= 2 || numj >= 2 || numt >= 2)
                        eva = eva + (200*numi) + (200*numj) + (200*numj);

                     numi = 0;
                     numj = 0;
                     numt = 0;

                    if(XO[i][0].contains("O"))
                        numi ++;
                    if(XO[i][1].contains("O"))
                        numi ++;
                    if(XO[i][2].contains("O"))
                        numi ++;

                    if(XO[0][j].contains("O"))
                        numj ++;
                    if(XO[1][j].contains("O"))
                        numj ++;
                    if(XO[2][j].contains("O"))
                        numj ++;

                    if(XO[0][0].contains("O"))
                        numt ++;
                    if(XO[1][1].contains("O"))
                        numt ++;
                    if(XO[2][2].contains("O"))
                        numt ++;

                    if(XO[2][0].contains("O"))
                        numt ++;
                    if(XO[1][1].contains("O"))
                        numt ++;
                    if(XO[0][2].contains("O"))
                        numt ++;

                    if(numi >= 2 || numj >= 2 || numt >= 2)
                        eva = eva + (120*numi) + (120*numj) + (120*numj);

                    numi = 0 ;
                    numj = 0 ;
                    numt = 0;

                    if(XO[i][0].contains("-"))
                        numi ++;
                    if(XO[i][1].contains("-"))
                        numi ++;
                    if(XO[i][2].contains("-"))
                        numi ++;

                    if(XO[0][j].contains("-"))
                        numj ++;
                    if(XO[1][j].contains("-"))
                        numj ++;
                    if(XO[2][j].contains("-"))
                        numj ++;

                    if(XO[0][0].contains("-"))
                        numt ++;
                    if(XO[1][1].contains("-"))
                        numt ++;
                    if(XO[2][2].contains("-"))
                        numt ++;

                    if(XO[2][0].contains("-"))
                        numt ++;
                    if(XO[1][1].contains("-"))
                        numt ++;
                    if(XO[0][2].contains("-"))
                        numt ++;

                    if(numi >= 3 || numj >= 3 || numt >= 3)
                        eva = eva + (100*numi) + (100*numj) + (100*numj);

                }


                if(aiFirst == false)
                {
                    if(       ( XO[i][0].contains("O")||XO[i][0].contains("-") )   &&
                            ( XO[i][1].contains("O")||XO[i][1].contains("-") )   &&
                            ( XO[i][2].contains("O")||XO[i][2].contains("-") )    )
                        eva++;



                    if(     ( XO[0][j].contains("O")||XO[0][j].contains("-") )   &&
                            ( XO[1][j].contains("O")||XO[1][j].contains("-") )   &&
                            ( XO[2][j].contains("O")||XO[2][j].contains("-") )    )
                        eva++;



                    if(i==j)
                    {
                        if(     ( XO[0][0].contains("O")||XO[0][0].contains("-") )   &&
                                ( XO[1][1].contains("O")||XO[1][1].contains("-") )   &&
                                ( XO[2][2].contains("O")||XO[2][2].contains("-") )    )
                            eva++;
                        else
                            eva--;
                    }
                    if (i+j==2)
                    {
                        if ((XO[2][0].contains("O") || XO[2][0].contains("-")) &&
                                (XO[1][1].contains("O") || XO[1][1].contains("-")) &&
                                (XO[2][0].contains("O") || XO[2][0].contains("-")))
                            eva++;
                        else
                            eva--;
                    }




                    if(XO[i][j].contains("-"))
                        eva+=200;

                    if(XO[i][j].contains("X")||XO[i][j].contains("O"))
                        eva-=200000;


                    int numi = 0;
                    int numj = 0;
                    int numt = 0;

                    if(XO[i][0].contains("O"))
                        numi ++;
                    if(XO[i][1].contains("O"))
                        numi ++;
                    if(XO[i][2].contains("O"))
                        numi ++;

                    if(XO[0][j].contains("O"))
                        numj ++;
                    if(XO[1][j].contains("O"))
                        numj ++;
                    if(XO[2][j].contains("O"))
                        numj ++;

                    if(XO[0][0].contains("O"))
                        numt ++;
                    if(XO[1][1].contains("O"))
                        numt ++;
                    if(XO[2][2].contains("O"))
                        numt ++;

                    if(XO[2][0].contains("O"))
                        numt ++;
                    if(XO[1][1].contains("O"))
                        numt ++;
                    if(XO[0][2].contains("O"))
                        numt ++;

                    if(numi >= 2 || numj >= 2 || numt >= 2)
                        eva = eva + (200*numi) + (200*numj) + (200*numj);

                    numi = 0;
                    numj = 0;
                    numt = 0;

                    if(XO[i][0].contains("X"))
                        numi ++;
                    if(XO[i][1].contains("X"))
                        numi ++;
                    if(XO[i][2].contains("X"))
                        numi ++;

                    if(XO[0][j].contains("X"))
                        numj ++;
                    if(XO[1][j].contains("X"))
                        numj ++;
                    if(XO[2][j].contains("X"))
                        numj ++;

                    if(XO[0][0].contains("X"))
                        numt ++;
                    if(XO[1][1].contains("X"))
                        numt ++;
                    if(XO[2][2].contains("X"))
                        numt ++;

                    if(XO[2][0].contains("X"))
                        numt ++;
                    if(XO[1][1].contains("X"))
                        numt ++;
                    if(XO[0][2].contains("X"))
                        numt ++;

                    if(numi >= 2 || numj >= 2 || numt >= 2)
                        eva = eva + (120*numi) + (120*numj) + (120*numj);


                    numi = 0 ;
                    numj = 0 ;
                    numt = 0;

                    if(XO[i][0].contains("-"))
                        numi ++;
                    if(XO[i][1].contains("-"))
                        numi ++;
                    if(XO[i][2].contains("-"))
                        numi ++;

                    if(XO[0][j].contains("-"))
                        numj ++;
                    if(XO[1][j].contains("-"))
                        numj ++;
                    if(XO[2][j].contains("-"))
                        numj ++;

                    if(XO[0][0].contains("-"))
                        numt ++;
                    if(XO[1][1].contains("-"))
                        numt ++;
                    if(XO[2][2].contains("-"))
                        numt ++;

                    if(XO[2][0].contains("-"))
                        numt ++;
                    if(XO[1][1].contains("-"))
                        numt ++;
                    if(XO[0][2].contains("-"))
                        numt ++;

                    if(numi >= 3 || numj >= 3 || numt >= 3)
                        eva = eva + (100*numi) + (100*numj) + (100*numj);


                }






                System.out.print(eva+" ");

                evaSet[i][j] = eva;

            }

        return evaSet;
    }







}

