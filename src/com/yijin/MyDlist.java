package com.yijin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class MyDlist extends DList {

	public MyDlist() {
		super();
	}

	public MyDlist(String f) {
		super();
		if ("stdin".equals(f)) {
			loadFromStdin();
		} else {
			loadFromFile(f);
		}
	}

	private void loadFromStdin() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));

			String input;
			DNode currentNode = header;
			while (!isEmpty(input = br.readLine())) {
				DNode node = new DNode(input, null, null);
				addAfter(currentNode, node);
				currentNode = node;
			}
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	private void loadFromFile(String f) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(f));
			StreamTokenizer st = new StreamTokenizer(br);
			st.eolIsSignificant(false);

			DNode currentNode = header;
			while (st.nextToken() != StreamTokenizer.TT_EOF) {
				switch (st.ttype) {
				case StreamTokenizer.TT_NUMBER: {
					DNode node = new DNode(fmt(st.nval), null, null);
					addAfter(currentNode, node);
					currentNode = node;
					break;
				}
				case StreamTokenizer.TT_WORD: {
					DNode node = new DNode(st.sval, null, null);
					addAfter(currentNode, node);
					currentNode = node;
					break;
				}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void printList() {
		try {
			DNode currentNode = getFirst();
			while (currentNode != null && currentNode != trailer) {
				System.out.println(currentNode.element);
				currentNode = getNext(currentNode);
			}
		} catch (IllegalStateException e) {
			System.out.println("This doubly linked list is empty!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static MyDlist cloneList(MyDlist u) {
		MyDlist ret = new MyDlist();
		DNode node = u.header;
		while ((node = u.getNext(node)) != u.trailer) {
			ret.addLast(new DNode(node.element, null, null));
		}
		return ret;
	}

	public static MyDlist concatenateList(MyDlist u, MyDlist v) {
		MyDlist ret = cloneList(u);
		DNode node = v.header;
		while ((node = u.getNext(node)) != v.trailer) {
			ret.addLast(new DNode(node.element, null, null));
		}
		return ret;
	}

	public void removeNode(String e) {
		DNode node = header;
		while ((node = getNext(node)) != trailer) {
			if (equals(e, node.element)) {
				DNode prev = node.prev;
				remove(node);
				node = prev;
			}
		}
	}

	/**
	 * Returns true if the string is null or 0-length.
	 * 
	 * @param str
	 *            the string to be examined
	 * @return true if str is null or zero length
	 */
	public static boolean isEmpty(CharSequence str) {
		if (str == null || str.length() == 0)
			return true;
		else
			return false;
	}

	public static boolean equals(String a, String b) {
		if (a == b)
			return true;
		if (a != null && b != null) {
			return a.equals(b);
		}
		return false;
	}

	public static String fmt(double d) {
		if (d == (int) d)
			return String.format("%d", new Object[]{Integer.valueOf((int)d)});
		else
			return String.format("%s", new Object[]{Double.valueOf(d)});
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out
				.println("please type some strings, one string each line and an empty line for the end of input:");
		/**
		 * Create the first doubly linked list by reading all the strings from
		 * the standard input.
		 */
		MyDlist firstList = new MyDlist("stdin");

		/** Print all elememts in firstList */
		firstList.printList();

		/**
		 * Create the second doubly linked list by reading all the strings from
		 * the file myfile that contains some strings.
		 */
		MyDlist secondList = new MyDlist("myfile");

		/** Print all elememts in secondList */
		secondList.printList();

		/** Innsert "data" into firstList */
		firstList.addFirst(new DNode("data", null, null));

		/** insert "structures" into firstList */
		firstList.addFirst(new DNode("structures", null, null));

		/** Print all elements in firstList. */
		firstList.printList();

		/** Innsert "data" into secondtList */
		secondList.addFirst(new DNode("data", null, null));

		/** insert "structures" into secondList */
		secondList.addFirst(new DNode("structures", null, null));

		/** Print all elements in secondList. */
		secondList.printList();

		/** Concatenate firstList and secondList into thirdList */
		MyDlist thirdList = concatenateList(firstList, secondList);

		/** Print all elements in thirdList. */
		thirdList.printList();

		/** Remove all the nodes in thirdList that contains "data". */
		thirdList.removeNode("data");

		/** Print thirdList. */
		thirdList.printList();

		/** Remove all the nodes in thirdList that contains "structures". */
		thirdList.removeNode("structures");

		/** Print thirdList. */
		thirdList.printList();

		/** Clone thirdList */
		MyDlist fourthList = cloneList(thirdList);

		/** Print all elements in fourthList. */
		fourthList.printList();
	}
}
