package puzzels.parser;

// solves http://codegolf.stackexchange.com/questions/35029/write-an-interpreter-for-my-esoteric-language-jumper/35277#35277

class P {
	def c = 0
	def p = 0
	def m = []

	P(i="") {
		m = i.collect { it as char}
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
	
	(s =~ /\(.*\)/).each {
		s = s.replace(it, "")
	}

	
	(s =~ /(\?)?([#><=+-:])([0-9]*)?/).collect {		
		def op = ops[it[2]]
		[f : op[0], v : Integer.parseInt(it[3] ?: op[1]), p : it[1] != null ]
		
	}
	
}

def printAsString(result) {
	println result.collect{it as char}.join("")
}

def program1 = "=72>=101>=108>=(kjs()k()jsbd)108>=111>=32>=119>=111>=114>=108>=100>=33>="

printAsString (new P().eval(parse(program1)))

def program2 = "?:2 :4 >1 :0 =33 >1 =0"
printAsString (new P("test").eval(parse(program2)))


println "sedgxgf".collect{ it as char}

