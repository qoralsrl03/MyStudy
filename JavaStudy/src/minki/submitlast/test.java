package minki.submitlast;

import java.util.Scanner;

public class test {
    private static boolean isLoggedIn = false;
    private static int selectedMenu = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (!isLoggedIn) {
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            // 로그인 처리
            if (isAuthenticated(username, password)) {
                isLoggedIn = true;
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }

        Thread stockInfoThread = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (selectedMenu == 1) {
                        // 주식 정보 출력
                        System.out.println("Stock Information:");
                        System.out.println("Name\tPrice\tChange%");
                        System.out.println("Apple\t$120\t+1.2%");
                        System.out.println("Google\t$2000\t-0.8%");
                        System.out.println("Amazon\t$3500\t+2.5%");
                        System.out.println("Microsoft\t$250\t-0.5%");
                        System.out.println();
                        selectedMenu = 0;
                    }
                }
                try {
                    Thread.sleep(1000); // 1초마다 주식 정보 갱신
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        stockInfoThread.start();

        Thread myStockThread = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (selectedMenu == 2) {
                        // 나의 주식 정보 출력
                        System.out.println("My Stock Information:");
                        System.out.println("Name\tPurchased Price");
                        System.out.println("Apple\t$100");
                        System.out.println("Microsoft\t$150");
                        System.out.println();
                        selectedMenu = 0;
                    }
                }
                try {
                    Thread.sleep(1000); // 1초마다 나의 주식 정보 갱신
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        myStockThread.start();

        while (true) {
            System.out.println("1. Stock Information");
            System.out.println("2. My Stocks");

            System.out.print("Select menu: ");
            selectedMenu = scanner.nextInt();

            if (selectedMenu != 1 && selectedMenu != 2) {
                System.out.println("Invalid menu. Please try again.");
            }
        }
    }

    private static boolean isAuthenticated(String username, String password) {
        // 로그인 인증 처리
        return true;
    }
}
