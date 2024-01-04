
package simple.medical.record.repository;

import simple.medical.record.domains.Doctor;

public class DoctorRepo extends BaseRepoStore<Doctor> {
    public DoctorRepo() {
        super("Doctor");
    }
}
