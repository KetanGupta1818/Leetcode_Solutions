function getLucky(s: string, k: number): number {
    let sum = 0;
    for(let i=0;i<s.length;i++){
        let cur_num = s.charCodeAt(i) - 'a'.charCodeAt(0) + 1;
        while(cur_num > 0){
            sum += cur_num%10;
            cur_num = Math.floor(cur_num/10);
        }
    }
    let answer = sum;
    while(--k > 0){
        let temp = 0;
            while(sum > 0){
                temp += sum%10;
                sum = Math.floor(sum/10);
            }
            answer = temp;
            sum = temp;
    }
    return answer;
};
