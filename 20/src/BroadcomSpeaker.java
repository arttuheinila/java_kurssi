public class BroadcomSpeaker extends BaseSpeaker {
    @Override
    public boolean unMute() {
        if (volume > 100) {
            isMuted = false;
            return false;
        }
        isMuted = false;
        return true;
    }
}
