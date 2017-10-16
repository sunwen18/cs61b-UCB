public class NBody {
	public static void main(String[] args){
        double T,dt;
        String filename;
		T  = Double.parseDouble(args[0]);
		dt = Double.parseDouble(args[1]);
		filename=args[2];

		double radius=NBody.readRadius(filename);
		Planet[] planets = NBody.readPlanets(filename);
        
        StdDraw.setScale(-radius, radius);
		StdDraw.picture(0,0, "starfield.jpg");
		StdAudio.loop( "audio/2001.mid");


		double t=0;
		double [] xForces= new double[5]; 
		double [] yForces= new double[5]; 
		for (t=0;t<T;t+=dt){
			for (int i=0;i<5;i++){
				xForces[i]=planets[i].calcNetForceExertedByX(planets);
				yForces[i]=planets[i].calcNetForceExertedByY(planets);
		    }
		    for (int j=0;j<5;j++){
		    	planets[j].update(dt,xForces[j],yForces[j]);
		    }
		    StdDraw.clear();
		    StdDraw.picture(0,0, "starfield.jpg");
		    for (Planet p : planets){
			    p.draw();
		    }

		    StdDraw.show(10);
		}
		StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
   			planets[i].xxPos, planets[i].yyPos, planets[i].xxVel, planets[i].yyVel, planets[i].mass, planets[i].imgFileName);	
}



	}


	public static double readRadius(String name){
		In in = new In(name);
		int number = in.readInt();
		double radius = in.readDouble();
		return radius;

	}

	public static Planet[] readPlanets(String name ){
		In in = new In(name);
		int i=in.readInt();
		double temp = in.readDouble();
		Planet [] planets; 
		planets=new Planet[i];
		for (int j=0;j<i;j++){
			
			planets[j]=new Planet(in.readDouble(),in.readDouble(),in.readDouble(),
				in.readDouble(),in.readDouble(),in.readString());
		}
		return planets;
	}

}
