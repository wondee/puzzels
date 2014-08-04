package puzzels.reversewords;

// solves https://code.google.com/codejam/contest/dashboard?c=351101#s=p1

def check(file) {
	
	def output = []
	def lines = new File(file).readLines()
	def testCount = lines[0].toInteger()
	def line = 1
	
	(0..testCount - 1).each {
		def words = lines[line++].split().reverse().join(" ")
		
		def result = "Case #${it + 1}: $words"
		
		println result
		output << result
		
		new File("out").withWriter { out ->
			output.each { out.writeLine(it) }
		}
	}

}


check("src/puzzels/reversewords/wordTest")