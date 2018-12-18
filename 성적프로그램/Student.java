public class Student {
	// 이름과 학번, 그리고 성적을 기입하기 위한 것.
	// 성적을 입력할 때, list로 할 지 map으로 할 지 고민중임.
	String name;
	String StudentId;
	String Mid;
	String Fin;
	String Subj;
	String Quiz;
	String Pre;
	String Report;
	String Attend;
	String Another;
	String all;
	String rank;

	public Student() {
	}

	public Student(String name, String studentId, String mid, String fin, String subj, String quiz, String pre,
			String report, String attend, String another) {
		super();
		this.name = name;
		StudentId = studentId;
		Mid = mid;
		Fin = fin;
		Subj = subj;
		Quiz = quiz;
		Pre = pre;
		Report = report;
		Attend = attend;
		Another = another;
		// this.all = null;
		// this.rank = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentId() {
		return StudentId;
	}

	public void setStudentId(String studentId) {
		StudentId = studentId;
	}

	public String getMid() {
		return Mid;
	}

	public void setMid(String mid) {
		Mid = mid;
	}

	public String getFin() {
		return Fin;
	}

	public void setFin(String fin) {
		Fin = fin;
	}

	public String getSubj() {
		return Subj;
	}

	public void setSubj(String subj) {
		Subj = subj;
	}

	public String getQuiz() {
		return Quiz;
	}

	public void setQuiz(String quiz) {
		Quiz = quiz;
	}

	public String getPre() {
		return Pre;
	}

	public void setPre(String pre) {
		Pre = pre;
	}

	public String getReport() {
		return Report;
	}

	public void setReport(String report) {
		Report = report;
	}

	public String getAttend() {
		return Attend;
	}

	public void setAttend(String attend) {
		Attend = attend;
	}

	public String getAnother() {
		return Another;
	}

	public void setAnother(String another) {
		Another = another;
	}

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public int getScore(String s) {
		int score = 0;
		switch (s) {
		case "Mid":
			score = Integer.parseInt(getMid());
			break;
		case "Fin":
			score = Integer.parseInt(getFin());
			break;
		case "Subj":
			score = Integer.parseInt(getSubj());
			break;
		case "Quiz":
			score = Integer.parseInt(getQuiz());
			break;
		case "Pre":
			score = Integer.parseInt(getPre());
			break;
		case "Report":
			score = Integer.parseInt(getReport());
			break;
		case "Attend":
			score = Integer.parseInt(getAttend());
			break;
		case "Another":
			score = Integer.parseInt(getAnother());
			break;
		// case "all":
		// allScore = Double.parseDouble(getAll());
		// return allScore;
		// break;
		// }
		}
		return score;
	}
}