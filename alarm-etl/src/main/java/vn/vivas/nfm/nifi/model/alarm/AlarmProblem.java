package vn.vivas.nfm.nifi.model.alarm;

public record AlarmProblem(
        int probableCauseID,
        String probableCause,
        String specificProblem,
        String problemText,
        String details
) {

    public AlarmProblem(
            int probableCauseID,
            String probableCause,
            String specificProblem
    ) {
        this(
                probableCauseID,
                probableCause,
                specificProblem,
                "UAM/UIM/MRN: " + String.format("%04d", probableCauseID)
                        + ". Detail: " + probableCause,
                "-"
        );
    }
}