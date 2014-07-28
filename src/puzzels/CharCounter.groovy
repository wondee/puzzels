package puzzels;


def input = 
"""
class P {
	def c = 0
	def p = 0
	def m = []

	P(i="") {
		m = i.chars.collect { it }
		m << 0
	}
	
	def set(v) { m[p] = v }
	def add(v) { m[p] += v }
	def sub(v) { m[p] -= v }

	def eval(i) {
		while(c < i.size()) {
			if (i[c].p && m[p] == 0) {
				c++
			} else {
				i[c].f(this,i[c].v)
			}
		}
		
		return m
	}
}


def parse(s) {
	
	def ops = [
	   
	   '#' : [{p, v -> p.p = v; p.c++}, "0"],
	   '>' : [{p, v -> p.p += v; p.c++}, "1"],
	   '<' : [{p, v -> p.p -= v; p.c++}, "1"],
	   '=' : [{p, v -> p.set(v); p.c++}, "0"],
	   '+' : [{p, v -> p.add(v); p.c++}, "1"],
	   '-' : [{p, v -> p.sub(v); p.c++}, "1"],
	   ':' : [{p, v -> p.c = v}, "0"]
	]
	
	(s =~ /f(.*f)/).each {
		s = s.replace(it, "")
	}

	
	(s =~ /(f?)?([#><=+-:])([0-9]*)?/).collect {		
		def op = ops[it[2]]
		[f : op[0], v : Integer.parseInt(it[3] ?: op[1]), p : it[1] != null ]
		
	}
	
}

"""

def nonChars = ['\n', ' ', '\t'] 


println input.collect{(!nonChars.contains(it)) ? 1 : 0}.sum()



