package bowling.state;

import bowling.point.Point;
import bowling.score.Score;

public class Strike implements State {

	private static final Strike CACHE = new Strike();
	private static final Point STRIKE_POINT = Point.max();

	private Strike() {
	}

	public static Strike getInstance() {
		return CACHE;
	}

	public static boolean isConstructible(Point point) {
		return point == STRIKE_POINT;
	}

	@Override
	public boolean isEnd() {
		return true;
	}

	@Override
	public State throwBowl(int throwCount) {
		throw new UnsupportedOperationException("투구를 할 수 없는 상태입니다.");
	}

	@Override
	public String symbol() {
		return "X";
	}

	@Override
	public Score score() {
		return Score.strike(STRIKE_POINT.score());
	}

	@Override
	public Score bonus(Score prevScore) {
		return prevScore.accumulate(STRIKE_POINT.score());
	}
}
