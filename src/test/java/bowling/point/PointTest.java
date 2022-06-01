package bowling.point;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import bowling.score.Score;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("투구 기록 테스트")
class PointTest {

	@Test
	void 투구_기록을_캐싱해서_Wrappinp_하는_객체를_생성() {
		Point actual = Point.of(1);
		Point expected = Point.of(1);

		assertThat(actual).isSameAs(expected);
	}

	@ParameterizedTest(name = "{displayName} : {arguments}")
	@ValueSource(ints = {-1, 11})
	void 투구_기록이_범위_안에_있지_않으면_예외(int throwCount) {
		assertThatIllegalArgumentException().isThrownBy(() -> Point.of(throwCount));
	}

	@Test
	void 투구기록_최댓값() {
		assertThat(Point.max()).isEqualTo(Point.of(10));
	}

	@Test
	void 투구기록_더하기() {
		Point first = Point.of(2);
		Point second = Point.of(3);
		assertThat(first.add(second)).isSameAs(Point.of(5));
	}

	@ParameterizedTest(name = "{displayName} : {arguments}")
	@CsvSource(
		delimiter = ':',
		value = {
			"1:1:false",
			"2:3:true",
			"3:2:false"
		}
	)
	void 투구기록_비교_테스트(int first, int second, boolean result) {
		Point point1 = Point.of(first);
		Point point2 = Point.of(second);

		assertThat(point1.isLessThan(point2)).isEqualTo(result);
	}

	@Test
	void 스코어_변환() {
		assertThat(Point.of(2).score()).isEqualTo(Score.of(2, 0));
	}
}