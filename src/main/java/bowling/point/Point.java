package bowling.point;

import java.util.HashMap;
import java.util.Map;

import bowling.util.Validator;

public class Point {

	private static final int MIN_THROW_COUNT = 0;
	private static final int MAX_THROW_COUNT = 10;
	private static final Map<Integer, Point> CACHE = new HashMap<>();

	static {
		for (int index = MIN_THROW_COUNT; index <= MAX_THROW_COUNT; index++) {
			CACHE.put(index, new Point(index));
		}
	}

	private final int value;

	private Point(int throwCount) {
		this.value = throwCount;
	}

	public static Point of(int throwCount) {
		Validator.min(MIN_THROW_COUNT, throwCount,
			String.format("투구 기록이 최솟값(%d) 보다 작습니다. 입력 : %d", MIN_THROW_COUNT, throwCount));
		Validator.max(MAX_THROW_COUNT, throwCount,
			String.format("투구 기록이 최댓값(%d) 보다 큽니다. 입력 : %d", MAX_THROW_COUNT, throwCount));
		return CACHE.get(throwCount);
	}
}