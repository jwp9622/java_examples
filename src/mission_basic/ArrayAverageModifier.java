package mission_basic;


public class ArrayAverageModifier {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        // 평균 계산
        double average = calculateAverage(arr);
        System.out.println("평균: " + average);

        // 방법 1: 배열 요소 평균 값으로 변경
        modifyArray(arr, average);

        // 변경된 배열 출력
        System.out.print("변경된 배열: ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();

        // 방법 2: 평균보다 큰 요소 값 감소 (예시)
        decreaseLargerValues(arr, average);

        // 변경된 배열 출력
        System.out.print("변경된 배열 (평균보다 큰 값 감소): ");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // 평균 계산 메서드
    public static double calculateAverage(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0; // 배열이 null이거나 비어있으면 0을 반환
        }

        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        return (double) sum / arr.length;
    }

    // 배열 요소 평균 값으로 변경 메서드
    public static void modifyArray(int[] arr, double average) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) average; // 평균 값으로 변경 (정수로 변환)
        }
    }

    // 평균보다 큰 요소 값 감소 메서드 (예시)
    public static void decreaseLargerValues(int[] arr, double average) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > average) {
                arr[i]--; // 평균보다 큰 요소 값 감소
            }
        }
    }
}
