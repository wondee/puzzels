package puzzels.numbersystem

// just a simple number system converter... to be extended

enum System {
	
	BINARY("01"),
	DEC("0123456789"),
	HEX("0123456789ABCDEF"),
	
	DUMMY("012356789")
	
	def System(digits) {
		this.digits = digits
	}
	
	String digits
	
	def resolve = {value ->
		(0 .. value.size() - 1)
			.collect {(digits.size() ** (value.size() - it - 1)) * digits.indexOf(value[it])}
			.inject {x, y -> x + y}
	}

}




println System.BINARY.resolve("10010")
println System.DEC.resolve("10010")
println System.HEX.resolve("AB")
