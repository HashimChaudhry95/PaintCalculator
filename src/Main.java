public class Main {
    public static void main(String[] args)
    {int height_of_walls_in_meters = 3;
     int width_of_wall_one_in_meters =2;
     double width_of_wall_two_in_meters=2.5;
     double area_of_ceiling= width_of_wall_one_in_meters * width_of_wall_two_in_meters;
     int paint_per_meter_squared_in_ml = 100;
     double total_area_of_walls_in_meter_squared = 2*height_of_walls_in_meters*width_of_wall_one_in_meters + 2*height_of_walls_in_meters*width_of_wall_two_in_meters + area_of_ceiling;
     int paint_required = (int) (total_area_of_walls_in_meter_squared * paint_per_meter_squared_in_ml);

     System.out.println(paint_required + "ml");



    }
}