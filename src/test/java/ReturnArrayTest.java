import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

public class ReturnArrayTest {
    @ParameterizedTest
    @MethodSource("actualAndExpectedResults")
    void shouldReturnArrayAfterLastValues(int[] array, int[] expected) {
        Assertions.assertArrayEquals(expected, ReturnArray.returnArray(array, 4));
    }

    private static Stream<Arguments> actualAndExpectedResults() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 2, 3, 4, 5, 6}, new int[]{5, 6}),
                Arguments.arguments(new int[]{1, 2, 3, 4, 4, 7, 8}, new int[]{7, 8}),
                Arguments.arguments(new int[]{1, 2, 3, 4}, new int[]{})
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @MethodSource("wrongParametersProvider")
    void shouldThrowRuntimeExceptionWhenValueNotFound(int[] parameters) {
                Assertions.assertNotNull(
                Assertions.assertThrows(
                        RuntimeException.class,
                       () -> ReturnArray.returnArray(parameters, 4)
                )
        );
    }

    private static Stream<int[]> wrongParametersProvider() {
        return Stream.of(new int[]{1, 2, 3});
    }

    @ParameterizedTest
    @MethodSource("actualAndExpectedResultsForMethodIsArrayContainValues")
    void shouldReturnTrueIsIsArrayContainValues(int[] array, boolean expected, int[] values){
        boolean result = ReturnArray.checkDigits(array, values[0], values[1]);
        Assertions.assertEquals(expected,result);
    }


    private static Stream<Arguments> actualAndExpectedResultsForMethodIsArrayContainValues() {
        return Stream.of(
                Arguments.arguments(new int[]{8, 7, 6, 5, 4}, true, new int[]{1,4}),
                Arguments.arguments(new int[]{6, 2, 3, 5}, false, new int[]{1,4}),
                Arguments.arguments(new int[]{2, 1, 3, 4}, true, new int[]{1,4}),
                Arguments.arguments(new int[]{4}, true, new int[]{1,4}),
                Arguments.arguments(new int[]{}, false, new int[]{1,4})
        );
    }
}
