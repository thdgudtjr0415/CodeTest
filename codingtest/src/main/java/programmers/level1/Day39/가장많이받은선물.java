package programmers.level1.Day39;

/*
* 이번 달까지 선물을 주고받은 기록을 바탕으로 다음 달에 누가 선물을 많이 받을지 예측
* 두사람이 선물 주고받은 기록 있다면 이번달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받는다
*   즉 A가 B에게 선물을 5번 줬고 B가 A에게 3번 줬다면 다음달엔  A가 B에게 선물 하나 받기
* 두사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면 선물 지수가 더큰 사람이 선물 지수가 더 작은 사람에게 선물 하나 받기
*   선물 지수는 이번 달 까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺸 값임
*   A가 친구들에게 준 선물 3개 받은 선물 10개라면, A의 선물지수는 -7, B가 준 선물이 3개 받은 선물 2개라면 지수 1,
*   만약 A와 B가 선물을 주고 받은 적이 없거나 정확히 같은 수로 선물을 주고 받앗다면 다음 달엔 B가 A에게 선물을 하나 받음
*   만약 두사람의 선물지수도 같다면 다음달에 선물을 주고 받지 않음
* 다음달에 가장 많은 선물을 받는 친구가 받을 선물의 수를 return
*/

/*
* 풀이 순서
* 1. 선물 지수 구하기
* 2. 선물을 주고 받은 두 사람 비교해서 선물을 하나 받음 -> 즉 다음달에 그 사람이 선물 몇개 받는지도 체크
* 3. 조건으로 두사람이 선물 주고 받은게 없거나, 주고받은수가 같다면 선물 지수가 더 큰 사람이 선물지수 작은 사람ㅇ게에 선물을 하나 받기
*   3-1. 선물지수도 갇나면 선물 주고 받지 않음
* 이때 친구 배열에서 0,1/0,2/0,3/1,2/1,3/2,3 이렇게 진행되어야하는 조합 공식 n*(n-1)/2 를 사용해서 풀어보기
*/

import java.util.HashMap;

public class 가장많이받은선물 {
    public int solution(String[] friends, String[] gifts) {
        int result = 0;
        // 선물 지수부터 구하기
        HashMap<String, Integer> nameToGiftCount = new HashMap<>();
        for(int i = 0; i < friends.length; i++){
            nameToGiftCount.put(friends[i], 0);
        }
        for(int i = 0; i < gifts.length; i++){
            String putName = gifts[i].split(" ")[0];
            String getName = gifts[i].split(" ")[1];
            nameToGiftCount.put(putName, nameToGiftCount.get(putName) + 1);
            nameToGiftCount.put(getName, nameToGiftCount.get(getName) - 1);
        }
        System.out.println(nameToGiftCount);

        // 선물 주고 받는거 체크, 자기 자신 인덱스에서는 체크 안함
        int[][] friendToGift = new int[friends.length][friends.length];
        for(int i = 0; i < gifts.length; i++){
            String putName = gifts[i].split(" ")[0];
            String getName = gifts[i].split(" ")[1];
            int idxI = 0;
            int idxJ = 0;
            for(int j = 0; j < friendToGift.length; j++){
                if(putName.equals(friends[j])){
                    idxI = j;
                }
                if(getName.equals(friends[j])){
                    idxJ = j;
                }
            }
                friendToGift[idxI][idxJ]++;
        }
        // 이제 선물 주고 받는거 비교해서 다음달에 선물 더 받을 사람
        int[] nextGift = new int[friends.length];
        for(int i = 0; i < friendToGift.length; i++){
            for(int j = i+1; j < friendToGift[i].length; j++){
                if(i == j) continue;
                if(friendToGift[i][j] > friendToGift[j][i]){
                    nextGift[i]++;
                }else if(friendToGift[i][j] < friendToGift[j][i]){
                    nextGift[j]++;
                }else if(friendToGift[i][j] == friendToGift[j][i]){
                    if(nameToGiftCount.get(friends[i]) > nameToGiftCount.get(friends[j])){
                        nextGift[i]++;
                    }else if(nameToGiftCount.get(friends[i]) < nameToGiftCount.get(friends[j])){
                        nextGift[j]++;
                    }
                }
            }
        }
        // 배열 이쁘게 보기
//        printArray(friendToGift);

        for(int i = 0; i < nextGift.length; i++){
            result = Math.max(nextGift[i], result);
        }

        return result;
    }

    public void printArray(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        가장많이받은선물 s = new 가장많이받은선물();
        System.out.println(s.solution(
                new String[]{"muzi", "ryan", "frodo", "neo"},
                new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"})); //2
        System.out.println(s.solution(
                new String[]{"joy", "brad", "alessandro", "conan", "david"},
                new String[]{"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"})); //4
        System.out.println(s.solution(
                new String[]{"a", "b", "c"},
                new String[]{"a b", "b a", "c a", "a c", "a c", "c a"})); //0
    }
}
