package mission_basic;


public class ArrayAverageModifier {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        // ��� ���
        double average = calculateAverage(arr);
        System.out.println("���: " + average);

        // ��� 1: �迭 ��� ��� ������ ����
        modifyArray(arr, average);

        // ����� �迭 ���
        System.out.print("����� �迭: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();

        // ��� 2: ��պ��� ū ��� �� ���� (����)
        decreaseLargerValues(arr, average);

        // ����� �迭 ���
        System.out.print("����� �迭 (��պ��� ū �� ����): ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // ��� ��� �޼���
    public static double calculateAverage(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0; // �迭�� null�̰ų� ��������� 0�� ��ȯ
        }

        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        return (double) sum / arr.length;
    }

    // �迭 ��� ��� ������ ���� �޼���
    public static void modifyArray(int[] arr, double average) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) average; // ��� ������ ���� (������ ��ȯ)
        }
    }

    // ��պ��� ū ��� �� ���� �޼��� (����)
    public static void decreaseLargerValues(int[] arr, double average) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > average) {
                arr[i]--; // ��պ��� ū ��� �� ����
            }
        }
    }
}
