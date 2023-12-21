package simple.medical.record.domains.MedicalRecordEntity;

public class Intake {
    private String timeUse; // morning, afternoon,...
    private int frequency;
    private String remark;

    public Intake(String timeUse, int frequency, String remark) {
        this.timeUse = timeUse;
        this.frequency = frequency;
        this.remark = remark;
    }

    public String getTimeUse() {
        return timeUse;
    }

    public void setTimeUse(String timeUse) {
        this.timeUse = timeUse;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
