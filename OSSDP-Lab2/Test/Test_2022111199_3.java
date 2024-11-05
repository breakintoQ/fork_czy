/**
 * 该单元测试类 Test_2022111199_3 设计了多种测试用例来验证 Solution3 类的 largestDivisibleSubset 方法的正确性。以下是对代码的评审：
 * 优点：
 * 覆盖全面：测试用例涵盖了多种输入情况，包括空输入、包含非正整数、包含重复元素、互质数、非互质数、单个元素以及多个有效解子集的情况。
 * 异常处理：对非法输入（如 null、空数组、包含非正整数、包含重复元素）进行了异常处理测试，确保方法能够正确抛出 IllegalArgumentException。
 * 明确的预期结果：每个测试用例都有明确的预期结果，并使用 assertEquals 或 assertTrue 进行验证。
 * 改进建议：
 * 代码注释：虽然有测试策略的注释，但可以在每个测试方法上方添加简短的注释，说明该测试的具体目的。
 * 测试方法命名：测试方法的命名已经比较清晰，但可以考虑更具体一些，例如 testInputIsCoprimeNumbers 可以改为 testInputIsCoprimeNumbersShouldReturnSingleElementSubset。
 * 边界条件测试：可以增加一些边界条件的测试，例如输入数组中包含非常大的数或非常小的数。
 * 代码复用：可以考虑将 Solution3 solution = new Solution3(); 提取到一个 @Before 方法中，以减少重复代码。
 */

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import Solution3.Solution3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Test_2022111199_3 {

    /**
     * 测试策略：
     * 1. 输入为 null
     * 2. 输入为空数组
     * 3. 输入包含非正整数（如负数或零）
     * 4. 输入包含重复元素
     * 5. 输入为正常的数组
     *    5.1 数组中的元素为互质数（没有共同因子的数）
     *    5.2 数组中的元素为非互质数（存在整除关系的数）
     *    5.3 数组仅包含单个元素
     *    5.4 数组中存在多个有效解子集
     */

    // 测试1：输入为null，应抛出IllegalArgumentException异常
    @Test(expected = IllegalArgumentException.class)
    public void testInputIsNull() {
        Solution3 solution = new Solution3();
        solution.largestDivisibleSubset(null);
    }

    // 测试2：输入为空数组，应抛出IllegalArgumentException异常
    @Test(expected = IllegalArgumentException.class)
    public void testInputIsEmptyArray() {
        Solution3 solution = new Solution3();
        solution.largestDivisibleSubset(new int[]{});
    }

    // 测试3：输入包含非正整数（如负数），应抛出IllegalArgumentException异常
    @Test(expected = IllegalArgumentException.class)
    public void testInputContainsNonPositiveInteger() {
        Solution3 solution = new Solution3();
        solution.largestDivisibleSubset(new int[]{1, -2, 3});
    }

    // 测试4：输入包含重复元素，应抛出IllegalArgumentException异常
    @Test(expected = IllegalArgumentException.class)
    public void testInputContainsDuplicateElements() {
        Solution3 solution = new Solution3();
        solution.largestDivisibleSubset(new int[]{1, 2, 2, 3});
    }

    // 测试5：正常输入的数组
    // 5.1：互质数的输入数组，预期返回单个元素的集合，因为没有其他数满足整除条件
    @Test
    public void testInputIsCoprimeNumbers() {
        Solution3 solution = new Solution3();
        List<Integer> result = solution.largestDivisibleSubset(new int[]{5, 7, 11});
        assertEquals(Arrays.asList(5), result);
    }

    // 5.2：非互质数的输入数组，预期返回包含最大整除子集的集合
    @Test
    public void testInputIsNonCoprimeNumbers() {
        Solution3 solution = new Solution3();
        List<Integer> result = solution.largestDivisibleSubset(new int[]{1, 2, 4, 8});
        assertEquals(Arrays.asList(1, 2, 4, 8), result);
    }

    // 5.3：单个元素的输入数组，预期返回该元素的集合
    @Test
    public void testInputIsSingleElement() {
        Solution3 solution = new Solution3();
        List<Integer> result = solution.largestDivisibleSubset(new int[]{10});
        assertEquals(Arrays.asList(10), result);
    }

    // 5.4：多个有效解子集（如[1,2] 和 [1,3]）均符合要求，验证其中一个正确性
    @Test
    public void testInputIsNormalArray() {
        Solution3 solution = new Solution3();
        List<Integer> result = solution.largestDivisibleSubset(new int[]{1, 2, 3});
        assertTrue(result.equals(Arrays.asList(1, 2)) || result.equals(Arrays.asList(1, 3)));
    }
}
