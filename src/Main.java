import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Set the dimensions to 0 and then ask for user input as long as dimensions are less than or equal to 0//

        double RoomWidthMetres = 0;
        double RoomHeightMetres = 0;
        double RoomLengthMetres = 0;

        Scanner userInput = new Scanner(System.in);

        do {
            System.out.println("Enter the width of the room in metres");
            RoomWidthMetres = Double.parseDouble(userInput.nextLine());
        }

        while (RoomWidthMetres <= 0);

        do {
            System.out.println("Enter the height of the room in metres");
            RoomHeightMetres = userInput.nextDouble();
        }

        while (RoomHeightMetres <= 0);

        do {
            System.out.println("Enter the length of the room in metres");
            RoomLengthMetres = userInput.nextDouble();
        }

        while (RoomLengthMetres <= 0);


        double CeilingArea = RoomLengthMetres * RoomWidthMetres;
        double WallOneArea = RoomLengthMetres * RoomHeightMetres;
        double WallTwoArea = RoomWidthMetres * RoomHeightMetres;

        double SurfaceAreaOfWalls = (2 * WallOneArea + CeilingArea + 2 * WallTwoArea);

        int PaintRequiredPerMeterSquared = 100; //ml//
        double PaintRequired = (SurfaceAreaOfWalls * PaintRequiredPerMeterSquared);


        System.out.println("Are there any objects on the wall? (doors,windows,switches etc) Enter yes or no");
        userInput.nextLine();
        String Obstruction = userInput.nextLine();
        Obstruction = Obstruction.toLowerCase();

        while (Obstruction.equals("yes")) {
            double[] Obstacle = new double[2];

            System.out.println("What is the height of the object in metres?");
            Obstacle[0] = userInput.nextDouble();

            System.out.println("What is the width of the object in metres?");
            Obstacle[1] = userInput.nextDouble();

            PaintRequired = PaintRequired - (Obstacle[0] * Obstacle[1]);

            System.out.println("Are there any more wall objects?");
            userInput.nextLine();
            Obstruction = userInput.nextLine();
            Obstruction = Obstruction.toLowerCase();
        }


        String PaintBrand = "";
        System.out.println("Enter the brand of paint you will be using: Dulux, Craig&Rose or Farrow&Ball");
        userInput.nextLine();
        PaintBrand = userInput.nextLine();

        double CostOfPaint = switch (PaintBrand) {
            case "dulux" -> 4;
            case "craig&rose" -> 16;
            case "farrow&ball" -> 20;
            default -> 4;

        };

        int Number_of_Tins;
        for (Number_of_Tins = 1; PaintRequired > 0; Number_of_Tins++) {
            PaintRequired = PaintRequired - 2500;
            if (PaintRequired < 0) {
                System.out.println(Number_of_Tins + " tins of paint are required");
            }
        }
        ;
        double TotalCostOfPaint = CostOfPaint * Number_of_Tins;

        System.out.println("The amount of paint required accounting for objects on the wall is " + PaintRequired + "ml");
        System.out.println("You will require " + Number_of_Tins + " tins of paint and in total this will cost £" + TotalCostOfPaint);
    }

}