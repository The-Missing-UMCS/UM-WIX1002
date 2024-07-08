package wix1002_2024_1.Q5;

import java.util.Optional;
import wix1002_2024_1.Q5.model.Pair;
import wix1002_2024_1.Q5.util.FileUtil;
import wix1002_2024_1.Q5.util.PairFinder;
import wix1002_2024_1.Q5.util.ParticipantInfoParser;
import wix1002_2024_1.Q5.util.SeatingUtil;

public class CheckPairing {
    public static void main(String[] args) {
        String relativeFilePath = "src\\wix1002_2024_1\\Q5\\participants.txt";
        String info = FileUtil.readFile(relativeFilePath);
        String[][] participantInfoMatrix = ParticipantInfoParser.parseParticipantInfo(info);
        Optional<Pair[]> pairs = PairFinder.findMatchingPairs(participantInfoMatrix);

        pairs.ifPresentOrElse(
                p -> System.out.println("Matching pairs found:\n" + SeatingUtil.arrangeSeating(p)),
                () -> System.out.println("No matching pairs found."));
    }

}
