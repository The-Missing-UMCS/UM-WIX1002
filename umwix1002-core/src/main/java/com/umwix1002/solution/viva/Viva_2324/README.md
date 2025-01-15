# Feedback

The feedback is shared with everyone who took part in Viva3 and faced some challenges.

## Advice 1 - Avoid using a `Scanner` for test cases

I've noticed some of you opting for the `Scanner` class to input test cases manually. Instead, consider using a `String[]` or `int[]`. This approach saves a lot of time. If you only have 1 or 2 test cases, using `Scanner` is acceptable. However, for 20 test cases, repeatedly entering the same information can be tedious.

## Advice 2 - Use `Alt + Shift + F` to format your code

Having readable code is crucial. Explore shortcut keys in your IDE, like `Alt + Shift + F`, to automate code formatting tasks.

## Advice 3 - Get familiar with data structures

Even if data structures aren't part of your syllabus, it's perfectly okay to learn about them. Take a look at `ArrayList`, `List`, `HashMap`, `LinkedHashMap`, `Set`, `HashSet`, and similar structures. Relying solely on arrays can limit flexibility.

## Advice 4 - Learn about `Comparable`

Avoid using bubble sort for sorting when not explicitly required. Some still use multiple arrays for sorting, which is inefficient. Instead, use a class and implement `Comparable`, employing `Collections.sort` or `Arrays.sort`. This not only reduces redundant code but also makes your code more readable and less error-prone.

## Advice 5 - Read the question before answering

Some missed the presence of Question 2. Avoid repeating such mistakes. Carefully read instructions before attempting to answer any questions.

## Advice 6 - Use ChatGPT to aid learning, not for direct solutions

While it's encouraged to use ChatGPT as a learning aid, refrain from using it solely for obtaining answers and copy-pasting. This approach doesn't contribute to your understanding. ChatGPT can assist with WIX1002, but your understanding is crucial.

## Advice 7 - Ensure Modularity Through Methods

Every change requested in the code can be addressed more easily if you ensure modularity in your design. For further details, see the `PokemonSortingSystem`. While hardcoding is allowed, it's wise to prepare in advance by refactoring your code. This approach limits the impact of any modifications.
