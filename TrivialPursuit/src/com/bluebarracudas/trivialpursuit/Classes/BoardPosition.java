package com.bluebarracudas.trivialpursuit.Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bluebarracudas.trivialpursuit.R;

public enum BoardPosition {
	COORDINATES_0_0{
		@Override
		public Position getPosition(){
			return new Position(0, 0);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout00;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout00Category0;
			case 1: return R.id.GridLayout00Category1;
			case 2: return R.id.GridLayout00Category2;
			case 3: return R.id.GridLayout00Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout00Category0ImageView0;
				case 1: return R.id.GridLayout00Category0ImageView1;
				case 2: return R.id.GridLayout00Category0ImageView2;
				case 3: return R.id.GridLayout00Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout00Category1ImageView0;
				case 1: return R.id.GridLayout00Category1ImageView1;
				case 2: return R.id.GridLayout00Category1ImageView2;
				case 3: return R.id.GridLayout00Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout00Category2ImageView0;
				case 1: return R.id.GridLayout00Category2ImageView1;
				case 2: return R.id.GridLayout00Category2ImageView2;
				case 3: return R.id.GridLayout00Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout00Category3ImageView0;
				case 1: return R.id.GridLayout00Category3ImageView1;
				case 2: return R.id.GridLayout00Category3ImageView2;
				case 3: return R.id.GridLayout00Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_0_1{
		@Override
		public Position getPosition(){
			return new Position(0, 1);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout01;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout01Category0;
			case 1: return R.id.GridLayout01Category1;
			case 2: return R.id.GridLayout01Category2;
			case 3: return R.id.GridLayout01Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout01Category0ImageView0;
				case 1: return R.id.GridLayout01Category0ImageView1;
				case 2: return R.id.GridLayout01Category0ImageView2;
				case 3: return R.id.GridLayout01Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout01Category1ImageView0;
				case 1: return R.id.GridLayout01Category1ImageView1;
				case 2: return R.id.GridLayout01Category1ImageView2;
				case 3: return R.id.GridLayout01Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout01Category2ImageView0;
				case 1: return R.id.GridLayout01Category2ImageView1;
				case 2: return R.id.GridLayout01Category2ImageView2;
				case 3: return R.id.GridLayout01Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout01Category3ImageView0;
				case 1: return R.id.GridLayout01Category3ImageView1;
				case 2: return R.id.GridLayout01Category3ImageView2;
				case 3: return R.id.GridLayout01Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_0_2{
		@Override
		public Position getPosition(){
			return new Position(0, 2);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout02;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout02Category0;
			case 1: return R.id.GridLayout02Category1;
			case 2: return R.id.GridLayout02Category2;
			case 3: return R.id.GridLayout02Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout02Category0ImageView0;
				case 1: return R.id.GridLayout02Category0ImageView1;
				case 2: return R.id.GridLayout02Category0ImageView2;
				case 3: return R.id.GridLayout02Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout02Category1ImageView0;
				case 1: return R.id.GridLayout02Category1ImageView1;
				case 2: return R.id.GridLayout02Category1ImageView2;
				case 3: return R.id.GridLayout02Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout02Category2ImageView0;
				case 1: return R.id.GridLayout02Category2ImageView1;
				case 2: return R.id.GridLayout02Category2ImageView2;
				case 3: return R.id.GridLayout02Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout02Category3ImageView0;
				case 1: return R.id.GridLayout02Category3ImageView1;
				case 2: return R.id.GridLayout02Category3ImageView2;
				case 3: return R.id.GridLayout02Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_0_3{
		@Override
		public Position getPosition(){
			return new Position(0, 3);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout03;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout03Category0;
			case 1: return R.id.GridLayout03Category1;
			case 2: return R.id.GridLayout03Category2;
			case 3: return R.id.GridLayout03Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout03Category0ImageView0;
				case 1: return R.id.GridLayout03Category0ImageView1;
				case 2: return R.id.GridLayout03Category0ImageView2;
				case 3: return R.id.GridLayout03Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout03Category1ImageView0;
				case 1: return R.id.GridLayout03Category1ImageView1;
				case 2: return R.id.GridLayout03Category1ImageView2;
				case 3: return R.id.GridLayout03Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout03Category2ImageView0;
				case 1: return R.id.GridLayout03Category2ImageView1;
				case 2: return R.id.GridLayout03Category2ImageView2;
				case 3: return R.id.GridLayout03Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout03Category3ImageView0;
				case 1: return R.id.GridLayout03Category3ImageView1;
				case 2: return R.id.GridLayout03Category3ImageView2;
				case 3: return R.id.GridLayout03Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_0_4{
		@Override
		public Position getPosition(){
			return new Position(0, 4);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout04;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout04Category0;
			case 1: return R.id.GridLayout04Category1;
			case 2: return R.id.GridLayout04Category2;
			case 3: return R.id.GridLayout04Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout04Category0ImageView0;
				case 1: return R.id.GridLayout04Category0ImageView1;
				case 2: return R.id.GridLayout04Category0ImageView2;
				case 3: return R.id.GridLayout04Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout04Category1ImageView0;
				case 1: return R.id.GridLayout04Category1ImageView1;
				case 2: return R.id.GridLayout04Category1ImageView2;
				case 3: return R.id.GridLayout04Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout04Category2ImageView0;
				case 1: return R.id.GridLayout04Category2ImageView1;
				case 2: return R.id.GridLayout04Category2ImageView2;
				case 3: return R.id.GridLayout04Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout04Category3ImageView0;
				case 1: return R.id.GridLayout04Category3ImageView1;
				case 2: return R.id.GridLayout04Category3ImageView2;
				case 3: return R.id.GridLayout04Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_0_5{
		@Override
		public Position getPosition(){
			return new Position(0, 5);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout05;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout05Category0;
			case 1: return R.id.GridLayout05Category1;
			case 2: return R.id.GridLayout05Category2;
			case 3: return R.id.GridLayout05Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout05Category0ImageView0;
				case 1: return R.id.GridLayout05Category0ImageView1;
				case 2: return R.id.GridLayout05Category0ImageView2;
				case 3: return R.id.GridLayout05Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout05Category1ImageView0;
				case 1: return R.id.GridLayout05Category1ImageView1;
				case 2: return R.id.GridLayout05Category1ImageView2;
				case 3: return R.id.GridLayout05Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout05Category2ImageView0;
				case 1: return R.id.GridLayout05Category2ImageView1;
				case 2: return R.id.GridLayout05Category2ImageView2;
				case 3: return R.id.GridLayout05Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout05Category3ImageView0;
				case 1: return R.id.GridLayout05Category3ImageView1;
				case 2: return R.id.GridLayout05Category3ImageView2;
				case 3: return R.id.GridLayout05Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_0_6{
		@Override
		public Position getPosition(){
			return new Position(0, 6);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout06;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout06Category0;
			case 1: return R.id.GridLayout06Category1;
			case 2: return R.id.GridLayout06Category2;
			case 3: return R.id.GridLayout06Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout06Category0ImageView0;
				case 1: return R.id.GridLayout06Category0ImageView1;
				case 2: return R.id.GridLayout06Category0ImageView2;
				case 3: return R.id.GridLayout06Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout06Category1ImageView0;
				case 1: return R.id.GridLayout06Category1ImageView1;
				case 2: return R.id.GridLayout06Category1ImageView2;
				case 3: return R.id.GridLayout06Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout06Category2ImageView0;
				case 1: return R.id.GridLayout06Category2ImageView1;
				case 2: return R.id.GridLayout06Category2ImageView2;
				case 3: return R.id.GridLayout06Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout06Category3ImageView0;
				case 1: return R.id.GridLayout06Category3ImageView1;
				case 2: return R.id.GridLayout06Category3ImageView2;
				case 3: return R.id.GridLayout06Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_1_0{
		@Override
		public Position getPosition(){
			return new Position(1, 0);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout10;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout10Category0;
			case 1: return R.id.GridLayout10Category1;
			case 2: return R.id.GridLayout10Category2;
			case 3: return R.id.GridLayout10Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout10Category0ImageView0;
				case 1: return R.id.GridLayout10Category0ImageView1;
				case 2: return R.id.GridLayout10Category0ImageView2;
				case 3: return R.id.GridLayout10Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout10Category1ImageView0;
				case 1: return R.id.GridLayout10Category1ImageView1;
				case 2: return R.id.GridLayout10Category1ImageView2;
				case 3: return R.id.GridLayout10Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout10Category2ImageView0;
				case 1: return R.id.GridLayout10Category2ImageView1;
				case 2: return R.id.GridLayout10Category2ImageView2;
				case 3: return R.id.GridLayout10Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout10Category3ImageView0;
				case 1: return R.id.GridLayout10Category3ImageView1;
				case 2: return R.id.GridLayout10Category3ImageView2;
				case 3: return R.id.GridLayout10Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_2_0{
		@Override
		public Position getPosition(){
			return new Position(2, 0);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout20;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout20Category0;
			case 1: return R.id.GridLayout20Category1;
			case 2: return R.id.GridLayout20Category2;
			case 3: return R.id.GridLayout20Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout20Category0ImageView0;
				case 1: return R.id.GridLayout20Category0ImageView1;
				case 2: return R.id.GridLayout20Category0ImageView2;
				case 3: return R.id.GridLayout20Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout20Category1ImageView0;
				case 1: return R.id.GridLayout20Category1ImageView1;
				case 2: return R.id.GridLayout20Category1ImageView2;
				case 3: return R.id.GridLayout20Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout20Category2ImageView0;
				case 1: return R.id.GridLayout20Category2ImageView1;
				case 2: return R.id.GridLayout20Category2ImageView2;
				case 3: return R.id.GridLayout20Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout20Category3ImageView0;
				case 1: return R.id.GridLayout20Category3ImageView1;
				case 2: return R.id.GridLayout20Category3ImageView2;
				case 3: return R.id.GridLayout20Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_3_0{
		@Override
		public Position getPosition(){
			return new Position(3, 0);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout30;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout30Category0;
			case 1: return R.id.GridLayout30Category1;
			case 2: return R.id.GridLayout30Category2;
			case 3: return R.id.GridLayout30Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout30Category0ImageView0;
				case 1: return R.id.GridLayout30Category0ImageView1;
				case 2: return R.id.GridLayout30Category0ImageView2;
				case 3: return R.id.GridLayout30Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout30Category1ImageView0;
				case 1: return R.id.GridLayout30Category1ImageView1;
				case 2: return R.id.GridLayout30Category1ImageView2;
				case 3: return R.id.GridLayout30Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout30Category2ImageView0;
				case 1: return R.id.GridLayout30Category2ImageView1;
				case 2: return R.id.GridLayout30Category2ImageView2;
				case 3: return R.id.GridLayout30Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout30Category3ImageView0;
				case 1: return R.id.GridLayout30Category3ImageView1;
				case 2: return R.id.GridLayout30Category3ImageView2;
				case 3: return R.id.GridLayout30Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_4_0{
		@Override
		public Position getPosition(){
			return new Position(4, 0);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout40;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout40Category0;
			case 1: return R.id.GridLayout40Category1;
			case 2: return R.id.GridLayout40Category2;
			case 3: return R.id.GridLayout40Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout40Category0ImageView0;
				case 1: return R.id.GridLayout40Category0ImageView1;
				case 2: return R.id.GridLayout40Category0ImageView2;
				case 3: return R.id.GridLayout40Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout40Category1ImageView0;
				case 1: return R.id.GridLayout40Category1ImageView1;
				case 2: return R.id.GridLayout40Category1ImageView2;
				case 3: return R.id.GridLayout40Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout40Category2ImageView0;
				case 1: return R.id.GridLayout40Category2ImageView1;
				case 2: return R.id.GridLayout40Category2ImageView2;
				case 3: return R.id.GridLayout40Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout40Category3ImageView0;
				case 1: return R.id.GridLayout40Category3ImageView1;
				case 2: return R.id.GridLayout40Category3ImageView2;
				case 3: return R.id.GridLayout40Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_5_0{
		@Override
		public Position getPosition(){
			return new Position(5, 0);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout50;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout50Category0;
			case 1: return R.id.GridLayout50Category1;
			case 2: return R.id.GridLayout50Category2;
			case 3: return R.id.GridLayout50Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout50Category0ImageView0;
				case 1: return R.id.GridLayout50Category0ImageView1;
				case 2: return R.id.GridLayout50Category0ImageView2;
				case 3: return R.id.GridLayout50Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout50Category1ImageView0;
				case 1: return R.id.GridLayout50Category1ImageView1;
				case 2: return R.id.GridLayout50Category1ImageView2;
				case 3: return R.id.GridLayout50Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout50Category2ImageView0;
				case 1: return R.id.GridLayout50Category2ImageView1;
				case 2: return R.id.GridLayout50Category2ImageView2;
				case 3: return R.id.GridLayout50Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout50Category3ImageView0;
				case 1: return R.id.GridLayout50Category3ImageView1;
				case 2: return R.id.GridLayout50Category3ImageView2;
				case 3: return R.id.GridLayout50Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_6_0{
		@Override
		public Position getPosition(){
			return new Position(6, 0);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout60;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout60Category0;
			case 1: return R.id.GridLayout60Category1;
			case 2: return R.id.GridLayout60Category2;
			case 3: return R.id.GridLayout60Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout60Category0ImageView0;
				case 1: return R.id.GridLayout60Category0ImageView1;
				case 2: return R.id.GridLayout60Category0ImageView2;
				case 3: return R.id.GridLayout60Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout60Category1ImageView0;
				case 1: return R.id.GridLayout60Category1ImageView1;
				case 2: return R.id.GridLayout60Category1ImageView2;
				case 3: return R.id.GridLayout60Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout60Category2ImageView0;
				case 1: return R.id.GridLayout60Category2ImageView1;
				case 2: return R.id.GridLayout60Category2ImageView2;
				case 3: return R.id.GridLayout60Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout60Category3ImageView0;
				case 1: return R.id.GridLayout60Category3ImageView1;
				case 2: return R.id.GridLayout60Category3ImageView2;
				case 3: return R.id.GridLayout60Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_1_6{
		@Override
		public Position getPosition(){
			return new Position(1, 6);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout16;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout16Category0;
			case 1: return R.id.GridLayout16Category1;
			case 2: return R.id.GridLayout16Category2;
			case 3: return R.id.GridLayout16Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout16Category0ImageView0;
				case 1: return R.id.GridLayout16Category0ImageView1;
				case 2: return R.id.GridLayout16Category0ImageView2;
				case 3: return R.id.GridLayout16Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout16Category1ImageView0;
				case 1: return R.id.GridLayout16Category1ImageView1;
				case 2: return R.id.GridLayout16Category1ImageView2;
				case 3: return R.id.GridLayout16Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout16Category2ImageView0;
				case 1: return R.id.GridLayout16Category2ImageView1;
				case 2: return R.id.GridLayout16Category2ImageView2;
				case 3: return R.id.GridLayout16Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout16Category3ImageView0;
				case 1: return R.id.GridLayout16Category3ImageView1;
				case 2: return R.id.GridLayout16Category3ImageView2;
				case 3: return R.id.GridLayout16Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_2_6{
		@Override
		public Position getPosition(){
			return new Position(2, 6);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout26;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout26Category0;
			case 1: return R.id.GridLayout26Category1;
			case 2: return R.id.GridLayout26Category2;
			case 3: return R.id.GridLayout26Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout26Category0ImageView0;
				case 1: return R.id.GridLayout26Category0ImageView1;
				case 2: return R.id.GridLayout26Category0ImageView2;
				case 3: return R.id.GridLayout26Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout26Category1ImageView0;
				case 1: return R.id.GridLayout26Category1ImageView1;
				case 2: return R.id.GridLayout26Category1ImageView2;
				case 3: return R.id.GridLayout26Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout26Category2ImageView0;
				case 1: return R.id.GridLayout26Category2ImageView1;
				case 2: return R.id.GridLayout26Category2ImageView2;
				case 3: return R.id.GridLayout26Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout26Category3ImageView0;
				case 1: return R.id.GridLayout26Category3ImageView1;
				case 2: return R.id.GridLayout26Category3ImageView2;
				case 3: return R.id.GridLayout26Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_3_6{
		@Override
		public Position getPosition(){
			return new Position(3, 6);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout36;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout36Category0;
			case 1: return R.id.GridLayout36Category1;
			case 2: return R.id.GridLayout36Category2;
			case 3: return R.id.GridLayout36Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout36Category0ImageView0;
				case 1: return R.id.GridLayout36Category0ImageView1;
				case 2: return R.id.GridLayout36Category0ImageView2;
				case 3: return R.id.GridLayout36Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout36Category1ImageView0;
				case 1: return R.id.GridLayout36Category1ImageView1;
				case 2: return R.id.GridLayout36Category1ImageView2;
				case 3: return R.id.GridLayout36Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout36Category2ImageView0;
				case 1: return R.id.GridLayout36Category2ImageView1;
				case 2: return R.id.GridLayout36Category2ImageView2;
				case 3: return R.id.GridLayout36Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout36Category3ImageView0;
				case 1: return R.id.GridLayout36Category3ImageView1;
				case 2: return R.id.GridLayout36Category3ImageView2;
				case 3: return R.id.GridLayout36Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_4_6{
		@Override
		public Position getPosition(){
			return new Position(4, 6);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout46;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout46Category0;
			case 1: return R.id.GridLayout46Category1;
			case 2: return R.id.GridLayout46Category2;
			case 3: return R.id.GridLayout46Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout46Category0ImageView0;
				case 1: return R.id.GridLayout46Category0ImageView1;
				case 2: return R.id.GridLayout46Category0ImageView2;
				case 3: return R.id.GridLayout46Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout46Category1ImageView0;
				case 1: return R.id.GridLayout46Category1ImageView1;
				case 2: return R.id.GridLayout46Category1ImageView2;
				case 3: return R.id.GridLayout46Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout46Category2ImageView0;
				case 1: return R.id.GridLayout46Category2ImageView1;
				case 2: return R.id.GridLayout46Category2ImageView2;
				case 3: return R.id.GridLayout46Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout46Category3ImageView0;
				case 1: return R.id.GridLayout46Category3ImageView1;
				case 2: return R.id.GridLayout46Category3ImageView2;
				case 3: return R.id.GridLayout46Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_5_6{
		@Override
		public Position getPosition(){
			return new Position(5, 6);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout56;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout56Category0;
			case 1: return R.id.GridLayout56Category1;
			case 2: return R.id.GridLayout56Category2;
			case 3: return R.id.GridLayout56Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout56Category0ImageView0;
				case 1: return R.id.GridLayout56Category0ImageView1;
				case 2: return R.id.GridLayout56Category0ImageView2;
				case 3: return R.id.GridLayout56Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout56Category1ImageView0;
				case 1: return R.id.GridLayout56Category1ImageView1;
				case 2: return R.id.GridLayout56Category1ImageView2;
				case 3: return R.id.GridLayout56Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout56Category2ImageView0;
				case 1: return R.id.GridLayout56Category2ImageView1;
				case 2: return R.id.GridLayout56Category2ImageView2;
				case 3: return R.id.GridLayout56Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout56Category3ImageView0;
				case 1: return R.id.GridLayout56Category3ImageView1;
				case 2: return R.id.GridLayout56Category3ImageView2;
				case 3: return R.id.GridLayout56Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_6_1{
		@Override
		public Position getPosition(){
			return new Position(6, 1);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout61;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout61Category0;
			case 1: return R.id.GridLayout61Category1;
			case 2: return R.id.GridLayout61Category2;
			case 3: return R.id.GridLayout61Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout61Category0ImageView0;
				case 1: return R.id.GridLayout61Category0ImageView1;
				case 2: return R.id.GridLayout61Category0ImageView2;
				case 3: return R.id.GridLayout61Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout61Category1ImageView0;
				case 1: return R.id.GridLayout61Category1ImageView1;
				case 2: return R.id.GridLayout61Category1ImageView2;
				case 3: return R.id.GridLayout61Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout61Category2ImageView0;
				case 1: return R.id.GridLayout61Category2ImageView1;
				case 2: return R.id.GridLayout61Category2ImageView2;
				case 3: return R.id.GridLayout61Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout61Category3ImageView0;
				case 1: return R.id.GridLayout61Category3ImageView1;
				case 2: return R.id.GridLayout61Category3ImageView2;
				case 3: return R.id.GridLayout61Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_6_2{
		@Override
		public Position getPosition(){
			return new Position(6, 2);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout62;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout62Category0;
			case 1: return R.id.GridLayout62Category1;
			case 2: return R.id.GridLayout62Category2;
			case 3: return R.id.GridLayout62Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout62Category0ImageView0;
				case 1: return R.id.GridLayout62Category0ImageView1;
				case 2: return R.id.GridLayout62Category0ImageView2;
				case 3: return R.id.GridLayout62Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout62Category1ImageView0;
				case 1: return R.id.GridLayout62Category1ImageView1;
				case 2: return R.id.GridLayout62Category1ImageView2;
				case 3: return R.id.GridLayout62Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout62Category2ImageView0;
				case 1: return R.id.GridLayout62Category2ImageView1;
				case 2: return R.id.GridLayout62Category2ImageView2;
				case 3: return R.id.GridLayout62Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout62Category3ImageView0;
				case 1: return R.id.GridLayout62Category3ImageView1;
				case 2: return R.id.GridLayout62Category3ImageView2;
				case 3: return R.id.GridLayout62Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_6_3{
		@Override
		public Position getPosition(){
			return new Position(6, 3);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout63;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout63Category0;
			case 1: return R.id.GridLayout63Category1;
			case 2: return R.id.GridLayout63Category2;
			case 3: return R.id.GridLayout63Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout63Category0ImageView0;
				case 1: return R.id.GridLayout63Category0ImageView1;
				case 2: return R.id.GridLayout63Category0ImageView2;
				case 3: return R.id.GridLayout63Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout63Category1ImageView0;
				case 1: return R.id.GridLayout63Category1ImageView1;
				case 2: return R.id.GridLayout63Category1ImageView2;
				case 3: return R.id.GridLayout63Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout63Category2ImageView0;
				case 1: return R.id.GridLayout63Category2ImageView1;
				case 2: return R.id.GridLayout63Category2ImageView2;
				case 3: return R.id.GridLayout63Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout63Category3ImageView0;
				case 1: return R.id.GridLayout63Category3ImageView1;
				case 2: return R.id.GridLayout63Category3ImageView2;
				case 3: return R.id.GridLayout63Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_6_4{
		@Override
		public Position getPosition(){
			return new Position(6, 4);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout64;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout64Category0;
			case 1: return R.id.GridLayout64Category1;
			case 2: return R.id.GridLayout64Category2;
			case 3: return R.id.GridLayout64Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout64Category0ImageView0;
				case 1: return R.id.GridLayout64Category0ImageView1;
				case 2: return R.id.GridLayout64Category0ImageView2;
				case 3: return R.id.GridLayout64Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout64Category1ImageView0;
				case 1: return R.id.GridLayout64Category1ImageView1;
				case 2: return R.id.GridLayout64Category1ImageView2;
				case 3: return R.id.GridLayout64Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout64Category2ImageView0;
				case 1: return R.id.GridLayout64Category2ImageView1;
				case 2: return R.id.GridLayout64Category2ImageView2;
				case 3: return R.id.GridLayout64Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout64Category3ImageView0;
				case 1: return R.id.GridLayout64Category3ImageView1;
				case 2: return R.id.GridLayout64Category3ImageView2;
				case 3: return R.id.GridLayout64Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_6_5{
		@Override
		public Position getPosition(){
			return new Position(6, 5);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout65;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout65Category0;
			case 1: return R.id.GridLayout65Category1;
			case 2: return R.id.GridLayout65Category2;
			case 3: return R.id.GridLayout65Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout65Category0ImageView0;
				case 1: return R.id.GridLayout65Category0ImageView1;
				case 2: return R.id.GridLayout65Category0ImageView2;
				case 3: return R.id.GridLayout65Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout65Category1ImageView0;
				case 1: return R.id.GridLayout65Category1ImageView1;
				case 2: return R.id.GridLayout65Category1ImageView2;
				case 3: return R.id.GridLayout65Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout65Category2ImageView0;
				case 1: return R.id.GridLayout65Category2ImageView1;
				case 2: return R.id.GridLayout65Category2ImageView2;
				case 3: return R.id.GridLayout65Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout65Category3ImageView0;
				case 1: return R.id.GridLayout65Category3ImageView1;
				case 2: return R.id.GridLayout65Category3ImageView2;
				case 3: return R.id.GridLayout65Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_1_3{
		@Override
		public Position getPosition(){
			return new Position(1, 3);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout13;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout13Category0;
			case 1: return R.id.GridLayout13Category1;
			case 2: return R.id.GridLayout13Category2;
			case 3: return R.id.GridLayout13Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout13Category0ImageView0;
				case 1: return R.id.GridLayout13Category0ImageView1;
				case 2: return R.id.GridLayout13Category0ImageView2;
				case 3: return R.id.GridLayout13Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout13Category1ImageView0;
				case 1: return R.id.GridLayout13Category1ImageView1;
				case 2: return R.id.GridLayout13Category1ImageView2;
				case 3: return R.id.GridLayout13Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout13Category2ImageView0;
				case 1: return R.id.GridLayout13Category2ImageView1;
				case 2: return R.id.GridLayout13Category2ImageView2;
				case 3: return R.id.GridLayout13Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout13Category3ImageView0;
				case 1: return R.id.GridLayout13Category3ImageView1;
				case 2: return R.id.GridLayout13Category3ImageView2;
				case 3: return R.id.GridLayout13Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_2_3{
		@Override
		public Position getPosition(){
			return new Position(2, 3);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout23;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout23Category0;
			case 1: return R.id.GridLayout23Category1;
			case 2: return R.id.GridLayout23Category2;
			case 3: return R.id.GridLayout23Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout23Category0ImageView0;
				case 1: return R.id.GridLayout23Category0ImageView1;
				case 2: return R.id.GridLayout23Category0ImageView2;
				case 3: return R.id.GridLayout23Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout23Category1ImageView0;
				case 1: return R.id.GridLayout23Category1ImageView1;
				case 2: return R.id.GridLayout23Category1ImageView2;
				case 3: return R.id.GridLayout23Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout23Category2ImageView0;
				case 1: return R.id.GridLayout23Category2ImageView1;
				case 2: return R.id.GridLayout23Category2ImageView2;
				case 3: return R.id.GridLayout23Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout23Category3ImageView0;
				case 1: return R.id.GridLayout23Category3ImageView1;
				case 2: return R.id.GridLayout23Category3ImageView2;
				case 3: return R.id.GridLayout23Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_3_3{
		@Override
		public Position getPosition(){
			return new Position(3, 3);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout33;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout33Category0;
			case 1: return R.id.GridLayout33Category1;
			case 2: return R.id.GridLayout33Category2;
			case 3: return R.id.GridLayout33Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout33Category0ImageView0;
				case 1: return R.id.GridLayout33Category0ImageView1;
				case 2: return R.id.GridLayout33Category0ImageView2;
				case 3: return R.id.GridLayout33Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout33Category1ImageView0;
				case 1: return R.id.GridLayout33Category1ImageView1;
				case 2: return R.id.GridLayout33Category1ImageView2;
				case 3: return R.id.GridLayout33Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout33Category2ImageView0;
				case 1: return R.id.GridLayout33Category2ImageView1;
				case 2: return R.id.GridLayout33Category2ImageView2;
				case 3: return R.id.GridLayout33Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout33Category3ImageView0;
				case 1: return R.id.GridLayout33Category3ImageView1;
				case 2: return R.id.GridLayout33Category3ImageView2;
				case 3: return R.id.GridLayout33Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_4_3{
		@Override
		public Position getPosition(){
			return new Position(4, 3);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout43;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout43Category0;
			case 1: return R.id.GridLayout43Category1;
			case 2: return R.id.GridLayout43Category2;
			case 3: return R.id.GridLayout43Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout43Category0ImageView0;
				case 1: return R.id.GridLayout43Category0ImageView1;
				case 2: return R.id.GridLayout43Category0ImageView2;
				case 3: return R.id.GridLayout43Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout43Category1ImageView0;
				case 1: return R.id.GridLayout43Category1ImageView1;
				case 2: return R.id.GridLayout43Category1ImageView2;
				case 3: return R.id.GridLayout43Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout43Category2ImageView0;
				case 1: return R.id.GridLayout43Category2ImageView1;
				case 2: return R.id.GridLayout43Category2ImageView2;
				case 3: return R.id.GridLayout43Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout43Category3ImageView0;
				case 1: return R.id.GridLayout43Category3ImageView1;
				case 2: return R.id.GridLayout43Category3ImageView2;
				case 3: return R.id.GridLayout43Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_5_3{
		@Override
		public Position getPosition(){
			return new Position(5, 3);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout53;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout53Category0;
			case 1: return R.id.GridLayout53Category1;
			case 2: return R.id.GridLayout53Category2;
			case 3: return R.id.GridLayout53Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout53Category0ImageView0;
				case 1: return R.id.GridLayout53Category0ImageView1;
				case 2: return R.id.GridLayout53Category0ImageView2;
				case 3: return R.id.GridLayout53Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout53Category1ImageView0;
				case 1: return R.id.GridLayout53Category1ImageView1;
				case 2: return R.id.GridLayout53Category1ImageView2;
				case 3: return R.id.GridLayout53Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout53Category2ImageView0;
				case 1: return R.id.GridLayout53Category2ImageView1;
				case 2: return R.id.GridLayout53Category2ImageView2;
				case 3: return R.id.GridLayout53Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout53Category3ImageView0;
				case 1: return R.id.GridLayout53Category3ImageView1;
				case 2: return R.id.GridLayout53Category3ImageView2;
				case 3: return R.id.GridLayout53Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_3_1{
		@Override
		public Position getPosition(){
			return new Position(3, 1);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout31;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout31Category0;
			case 1: return R.id.GridLayout31Category1;
			case 2: return R.id.GridLayout31Category2;
			case 3: return R.id.GridLayout31Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout31Category0ImageView0;
				case 1: return R.id.GridLayout31Category0ImageView1;
				case 2: return R.id.GridLayout31Category0ImageView2;
				case 3: return R.id.GridLayout31Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout31Category1ImageView0;
				case 1: return R.id.GridLayout31Category1ImageView1;
				case 2: return R.id.GridLayout31Category1ImageView2;
				case 3: return R.id.GridLayout31Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout31Category2ImageView0;
				case 1: return R.id.GridLayout31Category2ImageView1;
				case 2: return R.id.GridLayout31Category2ImageView2;
				case 3: return R.id.GridLayout31Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout31Category3ImageView0;
				case 1: return R.id.GridLayout31Category3ImageView1;
				case 2: return R.id.GridLayout31Category3ImageView2;
				case 3: return R.id.GridLayout31Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_3_2{
		@Override
		public Position getPosition(){
			return new Position(3, 2);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout32;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout32Category0;
			case 1: return R.id.GridLayout32Category1;
			case 2: return R.id.GridLayout32Category2;
			case 3: return R.id.GridLayout32Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout32Category0ImageView0;
				case 1: return R.id.GridLayout32Category0ImageView1;
				case 2: return R.id.GridLayout32Category0ImageView2;
				case 3: return R.id.GridLayout32Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout32Category1ImageView0;
				case 1: return R.id.GridLayout32Category1ImageView1;
				case 2: return R.id.GridLayout32Category1ImageView2;
				case 3: return R.id.GridLayout32Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout32Category2ImageView0;
				case 1: return R.id.GridLayout32Category2ImageView1;
				case 2: return R.id.GridLayout32Category2ImageView2;
				case 3: return R.id.GridLayout32Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout32Category3ImageView0;
				case 1: return R.id.GridLayout32Category3ImageView1;
				case 2: return R.id.GridLayout32Category3ImageView2;
				case 3: return R.id.GridLayout32Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_3_4{
		@Override
		public Position getPosition(){
			return new Position(3, 4);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout34;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout34Category0;
			case 1: return R.id.GridLayout34Category1;
			case 2: return R.id.GridLayout34Category2;
			case 3: return R.id.GridLayout34Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout34Category0ImageView0;
				case 1: return R.id.GridLayout34Category0ImageView1;
				case 2: return R.id.GridLayout34Category0ImageView2;
				case 3: return R.id.GridLayout34Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout34Category1ImageView0;
				case 1: return R.id.GridLayout34Category1ImageView1;
				case 2: return R.id.GridLayout34Category1ImageView2;
				case 3: return R.id.GridLayout34Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout34Category2ImageView0;
				case 1: return R.id.GridLayout34Category2ImageView1;
				case 2: return R.id.GridLayout34Category2ImageView2;
				case 3: return R.id.GridLayout34Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout34Category3ImageView0;
				case 1: return R.id.GridLayout34Category3ImageView1;
				case 2: return R.id.GridLayout34Category3ImageView2;
				case 3: return R.id.GridLayout34Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_3_5{
		@Override
		public Position getPosition(){
			return new Position(3, 5);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout35;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout35Category0;
			case 1: return R.id.GridLayout35Category1;
			case 2: return R.id.GridLayout35Category2;
			case 3: return R.id.GridLayout35Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout35Category0ImageView0;
				case 1: return R.id.GridLayout35Category0ImageView1;
				case 2: return R.id.GridLayout35Category0ImageView2;
				case 3: return R.id.GridLayout35Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout35Category1ImageView0;
				case 1: return R.id.GridLayout35Category1ImageView1;
				case 2: return R.id.GridLayout35Category1ImageView2;
				case 3: return R.id.GridLayout35Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout35Category2ImageView0;
				case 1: return R.id.GridLayout35Category2ImageView1;
				case 2: return R.id.GridLayout35Category2ImageView2;
				case 3: return R.id.GridLayout35Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout35Category3ImageView0;
				case 1: return R.id.GridLayout35Category3ImageView1;
				case 2: return R.id.GridLayout35Category3ImageView2;
				case 3: return R.id.GridLayout35Category3ImageView3;
				}
			}
			return 0;
		}
	},
	COORDINATES_6_6{
		@Override
		public Position getPosition(){
			return new Position(6, 6);
		}
		@Override
		public int getPositionIdentifier(){
			return R.id.GridLayout66;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
		@Override
		public int getTokenCategoryIdentifier(int token){
			switch(token){
			case 0: return R.id.GridLayout66Category0;
			case 1: return R.id.GridLayout66Category1;
			case 2: return R.id.GridLayout66Category2;
			case 3: return R.id.GridLayout66Category3;
			}
			return 0;
		}
		@Override
		public int getTokenCategoryImageViewIdentifier(int token, int category){
			switch(token){
			case 0: 
				switch(category){
				case 0: return R.id.GridLayout66Category0ImageView0;
				case 1: return R.id.GridLayout66Category0ImageView1;
				case 2: return R.id.GridLayout66Category0ImageView2;
				case 3: return R.id.GridLayout66Category0ImageView3;
				}
			case 1:
				switch(category){
				case 0: return R.id.GridLayout66Category1ImageView0;
				case 1: return R.id.GridLayout66Category1ImageView1;
				case 2: return R.id.GridLayout66Category1ImageView2;
				case 3: return R.id.GridLayout66Category1ImageView3;
				}
			case 2:
				switch(category){
				case 0: return R.id.GridLayout66Category2ImageView0;
				case 1: return R.id.GridLayout66Category2ImageView1;
				case 2: return R.id.GridLayout66Category2ImageView2;
				case 3: return R.id.GridLayout66Category2ImageView3;
				}
			case 3:
				switch(category){
				case 0: return R.id.GridLayout66Category3ImageView0;
				case 1: return R.id.GridLayout66Category3ImageView1;
				case 2: return R.id.GridLayout66Category3ImageView2;
				case 3: return R.id.GridLayout66Category3ImageView3;
				}
			}
			return 0;
		}
	};
	
	public abstract Position getPosition();
	public abstract int getPositionIdentifier();
	public abstract int getTokenCategoryImageViewIdentifier(int token, int category);
	public abstract int getTokenCategoryIdentifier(int token);
	public abstract int getCategoryIndex();
	
	public static List<BoardPosition> getValues(){
		return Arrays.asList(values());
	}
}
