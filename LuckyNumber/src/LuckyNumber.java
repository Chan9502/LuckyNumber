import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//
import static java.lang.System.arraycopy;
import static java.lang.System.out;

public class LuckyNumber {
    //tạo con số lucky_number
    /**khai báo biểu thức random kiểu int
     * vì phương thức random sẽ trả về giá trị tư 0.0 đến < 1, nên ta nhân giá trị trả về nhân với 100 --> sẽ nhận được dãy từ 0 đến 100
     * dùng phương pháp ép kiểu để trùng với KDL khai báo
     */
    static int luckyNu;
    private static String[] arr;

    public static void getLuckyNumber(){
        final int Max = 100;
        luckyNu = (int)(Math.random() * Max);
        out.println(luckyNu);
    }

        //tổng số lần chơi
        public static int totalPlay = 1;
        //Tổng số lần đoán, được cộng dồn sau mỗi lần chạy qua câu lệnh if
        public static int totalGussRound = 1;
        public static int totalGuss = 0;

        /* so lan du doan it nhat
        tao mot mang luu lai cac so lan của totalRound
        * */
        public static int bestGame;
        //tạo mảng mới
        public static void main(String[] args){
            //header trên màn hình
            System.out.println("Toi dang nghi mot con so trong khoang tu 0 den 100...");
            //goi ham lay so may man
            getLuckyNumber();
            //bắt đầu chơi - gọi hàm play()
            play();
        }
    public static void play(){
        Scanner sc = new Scanner(System.in);

        //hỏi người chơi về con số dự đoán
        out.print("Ban doan? ");

        int guessNu = sc.nextInt();
        //System.out.print(guessNu);

        //tiến hành so sánh số dự đoán và số may mắn

        //TH1: số dự đoán > số may mắn
        //return về lệnh "Số may mắn nhỏ hơn số dự đoán của bạn."
        if (guessNu > luckyNu){
            out.println("So may man nho hon so du doan cua ban.");
            totalGussRound++;
            totalGuss++;
            play();

            //TH 2 số dự đoán < số may mắn
            //hiện thông báo "Số may mắn lớn hơn số dự đoán của bạn."
        } else if (guessNu < luckyNu) {
            out.println("So may man lon hon so du doan cua ban.");
            totalGussRound++;
            totalGuss++;
            play();

        } else {
            totalGuss++;
            out.println("Chuc mung ban da doan dung con so may man sau" + " " + totalGussRound +" "+ "lan du doan!");

            check();
        }

    }

    // tao hàm check() để kiểm tra xem người chơi có muốn tiếp tục chơi hay không?
    public static void check(){
        out.print("Ban co muon tiep tuc choi hay khong?");
        Scanner sc = new Scanner(System.in);
        String replay = "yes";
        String answer = (sc.next()).toLowerCase();
        if(replay.contains(answer)){
            totalPlay++;
            totalGussRound = 1;
            //gọi lại hàm lấy luckyNumber mới
            getLuckyNumber();
            //gọi hàm Play() trò chơi tiếp tục
            play();
            //nếu không hiển thị kết quả người chơi
        }else {
            out.println("Ket qua tong qua cua tro choi: ");
            out.println("Tong so lan choi =  " + totalPlay);
            out.println("Tong so lan du doan = " + totalGuss);

            //tính số lần dự doán trung bình mõi lượt
            double avePlay;
            avePlay = (double) totalGuss / (double)totalPlay;
            out.printf("Tong lan du doan trung binh moi luot = " + avePlay + "\n");

            //số lần dự doán ít nhất:

//            for (int i = 0; i < arr.length; i++){
//                bestGame = arr[0];
//                if(bestGame > arr[i]){
//                    bestGame = arr[i];
//                    out.println("So lan du doan it nhat = " + bestGame);
//                }else {
//                    out.println("So lan du doan it nhat = " + bestGame);
//                }
//            }
        }
    }

}


