func add(a: int, b: int) -> int {
    c: int = a + b;
    return c;
}

arr: int[] = [1, 2, 3, 4, 5];
arr2: int[5];

i: int = 0;
while (i < 5) {
    arr2[i] = add(arr[i], 5);
    i++;
}
