package bowling.frame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Frames {

	private final List<Frame> values = new ArrayList<>();

	private Frames(List<Frame> frames) {
		this.values.addAll(frames);
	}

	public static Frames start() {
		Frame initialFrame = GeneralFrame.initialized(Frame.MIN_FRAME_NUMBER);
		return new Frames(List.of(initialFrame));
	}

	public boolean isEnd() {
		return values.stream()
			.allMatch(Frame::isEnd);
	}

	public void throwBowl(int throwCount) {
		Frame latestFrame = lastFrame();
		latestFrame.throwBowl(throwCount);
		latestFrame.nextFrame()
			.ifPresent(values::add);
	}

	private Frame lastFrame() {
		return values.get(values.size() - 1);
	}

	public int frameNumber() {
		return lastFrame().number();
	}

	public int sumUntil(int frameNumber) {
		return values.stream()
			.limit(frameNumber)
			.mapToInt(Frame::score)
			.sum();
	}

	public List<String> symbols() {
		return values.stream()
			.map(Frame::symbol)
			.collect(Collectors.toList());
	}

	public List<Frame> values() {
		return List.copyOf(values);
	}
}
