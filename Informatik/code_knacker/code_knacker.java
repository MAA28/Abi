class code_knacker {
	public static void main(String[] args) {
		String text = args[0];
		double[] distribution = get_distribution(text);
		System.out.println("\nDistribution:");
		for (int i = 0; i < distribution.length; i++) {
			System.out.println((char) (i + 97) + ":" + distribution[i]);	
		}
		
		double[] avg_dist = {
/*A*/		0.0558,
/*B*/		0.0196,
/*C*/		0.0316,
/*D*/		0.0498,
/*E*/		0.1693,
/*F*/		0.0149,
/*G*/		0.0302,
/*H*/		0.0498,
/*I*/		0.0802,
/*J*/		0.0024,
/*K*/		0.0132,
/*L*/		0.0360,
/*M*/		0.0255,
/*N*/		0.1053,
/*O*/		0.0224,
/*P*/		0.0067,
/*Q*/		0.0002,
/*R*/		0.0689,
/*S*/		0.0642,
/*T*/		0.0579,
/*U*/		0.0383,
/*V*/		0.0084,
/*W*/		0.0178,
/*X*/		0.0005,
/*Y*/		0.0005,
/*Z*/		0.0121 ,
		};

		double[] errors = get_errors(distribution, avg_dist);
		
		System.out.println("\nOffsets:");
		int index_of_lowest = 0;
		double lowest = 100;
		for (int i = 0; i < errors.length; i++) {
			System.out.println("+" + i + ":" + errors[i]);			
			if(errors[i] <= lowest) {
				lowest = errors[i];
				index_of_lowest = i;
			}
		}

		System.out.println("If you offset the text by " + index_of_lowest + " the text will have a distribution very similar to a average distribution for german texts ("  + lowest + ")");



	}

	public static double[] get_errors(double[] dist, double[] avg_dist) {
		double[] errors = new double[26];
		for(int i = 0; i < errors.length; i++) {
			double error = 0;
			for(int j = 0; j < dist.length; j++) {
				double avg_value = avg_dist[j];
				double value = dist[(j + i) % 26];

				error += (value - avg_value) * (value - avg_value);
			}
			errors[i] = error;
		}
		return errors;
	}

	public static double[] get_distribution(String text) {
		double[] distribution = new double[26];
		for (int i = 0; i < text.length(); i++) {
			int index = (int) text.charAt(i) - 97;
			distribution[index]+= 1/((double) text.length());
		}
		return distribution;
	}
}
