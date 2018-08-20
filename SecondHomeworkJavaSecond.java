/*
    *author Viktor Shkuratov
    * date 20/08/2018
 */
public class JavaSecondHomeWorkSecond {

    private static final int SIZE = 4;

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String [][] firstMassive = {{"3","2","1","0"},{"3","2","1","0"},{"3","2","1","0"},{"3","2","1","0"}};
        String [][] secondMassive = {{"3","2","1","0"},{"3","2","1","0"},{"3","2","1","0"},{"3","2","1","0"},
                {"3","2","1","0"},{"3","2","1","0"}};
        String [][] thirdMassive = {{"3","2","6","0"},{"3","2","1","0"},{"3","2","d","c"},{"3","2","1","a"}};

        getSumm(firstMassive);//Нормальное поведение
        getSumm(secondMassive);//Задание 1
        getSumm(thirdMassive);//Задание 2
    }

    public static class MyArraySizeException extends Exception{

        @Override
        public String getMessage() {
            return "Размер массива не равен 4!";
        }
    }

    public static class MyArrayDataException extends Exception{
        private int number;
        private int secondNumber;
        String symbol;

        public MyArrayDataException(int number, int secondNumber, String symbol) {
            this.number = number;
            this.secondNumber = secondNumber;
            this.symbol = symbol;
        }

        @Override
        public String getMessage() {
            return "Не удалось преобразовать в int символ в массиве где i = " + number + ",j = "+secondNumber
                    + " и символ= " + symbol;
        }
    }
    public static void getSumm(String[][] massive) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        int secondNumber = 0;
        if (massive.length != SIZE) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < massive.length; i++) {
            try {
                for (int j = 0; j < massive.length; j++) {
                    secondNumber = j;
                    sum += Integer.parseInt(massive [i][j]);
                }
            }catch (Exception e) {
                throw new MyArrayDataException(i,secondNumber, massive[i][secondNumber]);
            }
        }
        System.out.println("Your sum = " + sum);
    }
}
