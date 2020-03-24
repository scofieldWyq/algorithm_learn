### 1. 数组

关于数组来说，最常用的方式是

```java
// 创建
type[] array = new type[];
// 使用 元素定位：base_addr + type_size * index
array[index] = ?;
type var = array[index];
```

> 二维数组(Array[n][m])来说，元素定位是：`base_addr + type_size * (m * n + index)`

### 2. 支持伸缩的数组

>   普通的数组是固定的，这样数组如果面对变化的数据增长和减少来说，就会有空间不够用的问题。一般使用数据都会潜意识的认为 `数组是无限长度的`，
> 这样我们就不用关系数组越界的问题。

