public class CellPhone {
    private ITelephoneMic mic;
    private ITelephoneSpeaker speaker;
    
    public CellPhone() {}

    public CellPhone(ITelephoneMic mic, ITelephoneSpeaker speaker) {
        this.mic = mic;
        this.speaker = speaker;
    }

    public ITelephoneMic getMic() {
        return mic;
    }

    public void setMic(ITelephoneMic mic) {
        this.mic = mic;
    }

    public ITelephoneSpeaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(ITelephoneSpeaker speaker) {
        this.speaker = speaker;
    } 
}
