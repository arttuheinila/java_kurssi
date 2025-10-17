public class QualcommSpeaker extends BaseSpeaker {
    @Override
    public boolean unMute() {
        if (volume > 80) {
            isMuted = true;
            return false;
        }
        isMuted = false;
        return true;
    }
}
