package puzzels.rope

import groovy.transform.ToString;

// solves https://code.google.com/codejam/contest/619102/dashboard#s=p0

@ToString(includePackage = false, cache = true)
class Wire {
	def p1
	def p2
}

def check(file) {
	
	def output = []
	def lines = new File(file).readLines()
	def testCount = lines[0].toInteger()
	def line = 1
	
	(0..testCount - 1).each {
		def wireCount = lines[line++].toInteger()
		def wires = []
		
		(0..wireCount - 1).each {
			def actLine = lines[line++]
			
			def lineValues = actLine.split(" ").collect { it.toInteger() }
			
			wires << new Wire(p1:lineValues[0], p2:lineValues[1])
		}
		
		def visitedWires = [] as Set
		def count = 0
		wires.each { wire ->

			def upper = wires.findAll {it.p1 > wire.p1 && !visitedWires.contains(it)}
			def lower = wires.findAll {it.p1 < wire.p1 && !visitedWires.contains(it)}
			
			count += upper.findAll { it.p2 < wire.p2 }.size()
			count += lower.findAll { it.p2 > wire.p2 }.size()
			
			visitedWires << wire
		}
		
		def result = "Case #${it + 1}: $count"
		
		println result
		output << result
		
		new File("out").withWriter { out ->
			output.each { out.writeLine(it) }
		}
		
	} 
	
}


check("src/puzzels/rope/ropeTest")
