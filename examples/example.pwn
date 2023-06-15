func add(a: int, b: int) -> int {
    c: int = a + b;
    return c;
}

arr: int[] = int[10];

for(i: int in 0..10) {
    arr[i] = add(i, 5);
}

j: int = 5;

while(j >= 0) {
    j--;
}