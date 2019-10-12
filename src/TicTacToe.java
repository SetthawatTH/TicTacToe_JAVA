import java.awt.*;
import java.util.Scanner;

public class TicTacToe {
    private String XO[][] = new String[3][3];

    int end = 0;
    int turn = 1;
    int draw = 0;


    public TicTacToe()
    {
        boolean pf = playOrder();
        startTable();
        showTable();
        playGame(pf);


        System.out.println("Game End : " );
        for(int i = 0 ; i <= 2 ; i++)
            for(int j = 0 ; j <= 2 ; j++)
                if(XO[i][j].contains("X")||XO[i][j].contains("O"))
                    draw++;
        if (turn%2==0&&draw<9)
            System.out.print("X Win");
        else if(turn%2==1&&draw<9)
            System.out.print("O Win");
        else if(draw>=9)
            System.out.print("draw");




    }

    private boolean playOrder()
    {
        boolean playFirst = false;
        System.out.print("Do you play first (Y/N) : ");
        Scanner kb = new Scanner(System.in);
        String check = kb.next();
        if(check.contains("Y"))
        {
            System.out.println("You will play first.");
            playFirst = true;
        }
        else if(check.contains("N"))
        {
            System.out.println("You will play second.");
            playFirst = false;
        }
        return playFirst;
    }



    private void startTable()
    {
        for(int i = 0 ; i < 3 ; i++ )
        {
            for(int j = 0 ; j < 3 ; j++ )
            {
                XO[i][j] = "-";
            }
        }
    }

    private void showTable()
    {
        for(int i = 0 ; i < 3 ; i++ )
        {
            for(int j = 0 ; j < 3 ; j++ )
            {
                System.out.print(" "+XO[i][j]+" ");
            }

            System.out.println();
        }
        System.out.println("------------------");

    }

    private void setTable(int i , int j , String x)
    {

        XO [i][j] = x;
    }

    private int checkEnd()
    {


        if( XO[0][0].equals(XO[1][1]) && XO[1][1].equals(XO[2][2]))
        {
            if((XO[0][0].contains("X"))||(XO[0][0].contains("O")))
            {
                end = 1;
            }
        }

        if( XO[0][2].equals(XO[1][1]) && XO[1][1].equals(XO[2][0]))
        {
            if((XO[0][2].contains("X"))||(XO[0][2].contains("O")))
            {
                end = 1;
            }
        }

        for(int i = 0 ; i <= 2 ; i++)
        {
            if((XO[i][0]).equals(XO[i][1])&&(XO[i][1]).equals(XO[i][2]))

                if((XO[i][0]).contains("X")||(XO[i][0]).contains("O"))

                {
                    end = 1;
                }

        }

        for(int i = 0 ; i <= 2 ; i++)
        {
            if((XO[0][i]).equals(XO[1][i])&&(XO[1][i]).equals(XO[2][i]))

                if((XO[0][i]).contains("X")||(XO[0][i]).contains("O"))

                {
                    end = 1;
                }

        }

        draw=0;
        for(int i = 0 ; i <= 2 ; i++)
            for(int j = 0 ; j <= 2 ; j++)
                if(XO[i][j].contains("X")||XO[i][j].contains("O"))
                    draw++;
         if(draw>9)
             end = 1;



        return end;
    }


    private void readXO(boolean pf)
    {
        int i = 0;
        int j = 0;
        /*if(turn%2==0)
            System.out.println("Play 'X'");
        else
            System.out.println("Play 'O'");
        */
        Scanner kb = new Scanner(System.in);
        do {

            System.out.print("Reply Coordinate x : ");
            i = kb.nextInt();
            System.out.print("Reply Coordinate y : ");
            j = kb.nextInt();
        } while( (((i > 3 )||(i < 1)) || ((j > 3)||(j < 1))) || ((XO[i-1][j-1].contains("X")) || (XO[i-1][j-1].contains("O")) )) ;


        if(pf==true)
        {
            setTable(i-1,j-1,"X");
        }
        else if(pf == false)
        {
            setTable(i-1,j-1,"O");
        }


    }

    private void playGame(boolean pf)
    {
        while(checkEnd()==0) {
            if (pf == true) {
                if (turn % 2 == 1)
                    turnPlayer(pf);
                else if (turn % 2 == 0)
                    turnAi(pf);
            } else {

                if (turn % 2 == 0)
                    turnPlayer(pf);
                else if (turn % 2 == 1)
                    turnAi(pf);
            }



        }
    }


    private void turnPlayer(boolean pf)
    {

            System.out.println("Turn : " + (turn++));
            System.out.println();
            readXO(pf);
            showTable();

    }

    private void turnAi(boolean pf)
    {

            System.out.println("Turn : " + (turn++));
            System.out.println();
            int aiChoose[] = new int[2];
            aiChoose = new Evaluation(XO,!pf).chooseEva();
            if(pf==true)
                setTable(aiChoose[0],aiChoose[1],"O");
            else
                setTable(aiChoose[0],aiChoose[1],"X");

            showTable();
        //((XO[i-1][j-1].contains("X")) || (XO[i-1][j-1].contains("O")) )
    }

}
