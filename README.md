# qiangshizhuzai
方法1：使用对数组中的n个元素使用直接插入法全排序，然后取其中的前K个数，时间复杂度O(n^2)；
方法2：使用对数组中k个元素使用直接插入法排序，然后对剩余的n-k个元素分别和k个元素比较更新这k个元素，最终得到最小的k个元素，其中排序时间复杂度O(n^2)，
       比较时间复杂度O(n*k)，数组中元素移动时间复杂度O(n*k)，最终算法时间复杂度为O(n)，空间复杂度则是多出了存储最小K个元素数字的k个空间；
