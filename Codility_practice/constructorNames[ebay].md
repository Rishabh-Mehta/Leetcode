# constructorNames [ebay]

Give two Strings a and b find out if there is any possible to repalce the same frequency character
Input: a = babczzz, b = abbzccc
Output: true
Explanation:
In a string,
a -> 1, b -> 2, c-> 1 , z -> 3
In b string,
a -> 1, b -> 2, c -> 3, z -> 1
a and b are the same frequency.
c and z have same frequency so they can replace to each other.
So return true.

Input: a = x, b = y
Output: false
Explain: Not the same character

Input: a = ii, b = j
Output: false

The frequency of the two letters inside each string can also be interchanged, so this question only needs two strings. Each frequqncy appears the
same number of times. For example, "babzccc" and "bbazzcz" return "true" because z and c can be interchanged. But "babzcccm" and "bbazzczl" are different, because m appeared in the first one, and did not appear in the second.