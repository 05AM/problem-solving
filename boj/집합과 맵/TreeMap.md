## 🔷 TreeMap 정의

SortedMap 인터페이스와 그 기능을 확장한 NavigableMap 인터페이스도 구현하는 클래스로, 키를 자연 순서 또는 제공된 Comparator에 따라 정렬된 순서로 유지하는 맵을 정의한다.

### ➡ 생성
``` java
// 사전순
TreeMap<String, String> log = new TreeMap<>();

// 사전 역순
TreeMap<String, String> log = new TreeMap<>(Comparator.reverseOrder());
```

<br>

## 🔷 기본 메서드
- `put(K key, V value)`: 지정된 키와 값을 맵에 추가
- `get(Object key)`: 지정된 키와 연관된 값을 반환
- `remove(Object key)`: 지정된 키와 연관된 키-값 쌍을 제거
- `containsKey(Object key)`: 맵에 지정된 키가 있는지 확인
- `containsValue(Object value)`: 맵에 지정된 값이 있는지 확인
- `size()`: 맵에 있는 키-값 쌍의 수를 반환
- `clear()`: 맵의 모든 키-값 쌍을 제거

## 🔷 SortedMap 인터페이스의 메서드
- `firstKey()`: 맵의 첫 번째(가장 작은) 키를 반환
- `lastKey()`: 맵의 마지막(가장 큰) 키를 반환
- `headMap(K toKey)`: 지정된 키 이전의 모든 키-값 쌍을 포함하는 부분 맵을 반환
- `tailMap(K fromKey)`: 지정된 키 이후의 모든 키-값 쌍을 포함하는 부분 맵을 반환
- `subMap(K fromKey, K toKey)`: 지정된 두 키 사이의 모든 키-값 쌍을 포함하는 부분 맵을 반환

## 🔷 NavigableMap 인터페이스의 메서드
- `lowerEntry(K key)`: 지정된 키보다 작은 키를 가진 가장 큰 키-값 쌍을 반환
- `floorEntry(K key)`: 지정된 키와 같거나 작은 키를 가진 가장 큰 키-값 쌍을 반환
- `ceilingEntry(K key)`: 지정된 키와 같거나 큰 키를 가진 가장 작은 키-값 쌍을 반환
- `higherEntry(K key)`: 지정된 키보다 큰 키를 가진 가장 작은 키-값 쌍을 반환
- `descendingMap()`: 현재 맵의 역순을 나타내는 NavigableMap을 반환
- `pollFirstEntry()`: 맵에서 첫 번째(가장 작은) 키-값 쌍을 제거하고 반환
- `pollLastEntry()`: 맵에서 마지막(가장 큰) 키-값 쌍을 제거하고 반환

