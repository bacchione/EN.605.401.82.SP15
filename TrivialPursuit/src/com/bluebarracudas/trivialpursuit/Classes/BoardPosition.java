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
		public int getIdentifier(){
			return R.id.gridView00;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_0_1{
		@Override
		public Position getPosition(){
			return new Position(0, 1);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView01;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_0_2{
		@Override
		public Position getPosition(){
			return new Position(0, 2);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView02;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_0_3{
		@Override
		public Position getPosition(){
			return new Position(0, 3);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView03;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_0_4{
		@Override
		public Position getPosition(){
			return new Position(0, 4);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView04;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_0_5{
		@Override
		public Position getPosition(){
			return new Position(0, 5);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView05;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_0_6{
		@Override
		public Position getPosition(){
			return new Position(0, 6);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView06;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_1_0{
		@Override
		public Position getPosition(){
			return new Position(1, 0);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView10;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_2_0{
		@Override
		public Position getPosition(){
			return new Position(2, 0);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView20;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_3_0{
		@Override
		public Position getPosition(){
			return new Position(3, 0);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView30;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_4_0{
		@Override
		public Position getPosition(){
			return new Position(4, 0);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView40;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_5_0{
		@Override
		public Position getPosition(){
			return new Position(5, 0);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView50;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_6_0{
		@Override
		public Position getPosition(){
			return new Position(6, 0);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView60;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_1_6{
		@Override
		public Position getPosition(){
			return new Position(1, 6);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView16;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_2_6{
		@Override
		public Position getPosition(){
			return new Position(2, 6);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView26;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_3_6{
		@Override
		public Position getPosition(){
			return new Position(3, 6);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView36;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_4_6{
		@Override
		public Position getPosition(){
			return new Position(4, 6);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView46;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_5_6{
		@Override
		public Position getPosition(){
			return new Position(5, 6);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView56;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_6_1{
		@Override
		public Position getPosition(){
			return new Position(6, 1);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView61;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_6_2{
		@Override
		public Position getPosition(){
			return new Position(6, 2);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView62;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_6_3{
		@Override
		public Position getPosition(){
			return new Position(6, 3);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView63;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_6_4{
		@Override
		public Position getPosition(){
			return new Position(6, 4);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView64;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_6_5{
		@Override
		public Position getPosition(){
			return new Position(6, 5);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView65;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_1_3{
		@Override
		public Position getPosition(){
			return new Position(1, 3);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView13;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_2_3{
		@Override
		public Position getPosition(){
			return new Position(2, 3);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView23;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_3_3{
		@Override
		public Position getPosition(){
			return new Position(3, 3);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView33;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_4_3{
		@Override
		public Position getPosition(){
			return new Position(4, 3);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView43;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_5_3{
		@Override
		public Position getPosition(){
			return new Position(5, 3);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView53;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_3_1{
		@Override
		public Position getPosition(){
			return new Position(3, 1);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView31;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_3_2{
		@Override
		public Position getPosition(){
			return new Position(3, 2);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView32;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_3_4{
		@Override
		public Position getPosition(){
			return new Position(3, 4);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView34;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_3_5{
		@Override
		public Position getPosition(){
			return new Position(3, 5);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView35;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	},
	COORDINATES_6_6{
		@Override
		public Position getPosition(){
			return new Position(6, 6);
		}
		@Override
		public int getIdentifier(){
			return R.id.gridView66;
		}
		@Override
		public int getCategoryIndex(){
			return 0;
		}
	};
	
	public abstract Position getPosition();
	public abstract int getIdentifier();
	public abstract int getCategoryIndex();
	
	public static List<BoardPosition> getValues(){
		return Arrays.asList(values());
	}
}
