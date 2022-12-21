import java.util.*;

public  class Main {
    static int N = 100010;
    static int[] ne = new int[N];
    static int[] e = new int[N];
    static int idx, head;

    public static void init() {
        idx = 0;
        head = -1;
    }
    public static void add_head(int x) {
        e[idx] = x;
        ne[idx] = head;
        head = idx ++;
    }
    public static void remove(int k) {
        ne[k] = ne[ne[k]];
    }
    public static void add(int k, int x) {
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx ++;
    }

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int m = sc.nextInt();
       init();
       while (m -- > 0) {
           String s = sc.next();
           char op = s.charAt(0);

           if(op == 'H') {
               int x = sc.nextInt();
               add_head(x);
           }
           if(op == 'D') {
               int k = sc.nextInt();
               if(k == 0) head = ne[head];
               else remove(k - 1);
           } else {
               int k = sc.nextInt();
               int x = sc.nextInt();
               add(k - 1, x);
           }
       }
        for (int i = head; i != -1 ; i = ne[i]) {
            System.out.printf(e[i] + " ");
        }
          }
    }
