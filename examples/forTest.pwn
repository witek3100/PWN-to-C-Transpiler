arr1: int[] = [1, 2, 3, 4, 5];
arr2: int[] = [5,4,3,2,1];
arr3: int[5];

i: int = 0;
for (abc: int in arr1) {
    sum: int = 0;
    for (abcd: int in arr2) {
        sum += abcd;
    }
    arr3[i] = abc + sum;
    i++;
}