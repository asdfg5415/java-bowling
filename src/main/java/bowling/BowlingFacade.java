package bowling;

import bowling.dto.ResultDto;
import bowling.frame.Frames;
import bowling.pin.Pin;
import bowling.player.Player;

public class BowlingFacade {
    private Player player;
    private Frames frames;

    private BowlingFacade(final Player player, final Frames frames) {
        this.player = player;
        this.frames = frames;
    }

    public static BowlingFacade of(final Player player, final Frames frames) {
        return new BowlingFacade(player, frames);
    }

    public void pitch(final Pin downedPins) {
        frames.pitch(downedPins);
    }

    public ResultDto getResult() {
        return ResultDto.of(player.convert(), frames.convert());
    }
}
