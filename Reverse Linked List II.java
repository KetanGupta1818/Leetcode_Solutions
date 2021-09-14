		ListNode sen = new ListNode(0,head);
		ListNode prev = sen;
		for(int i=0;i<left-1;i++) {
			head = head.next;
			prev = prev.next;
		}
		ListNode last = head;
		for(int i=0;i<right-left;i++) last = last.next;
		ListNode end = last.next;
		last.next = null;
		prev.next = reverse(head);
		//while(prev.next!=null) prev = prev.next;
		//prev.next = end;
		head.next = end;
		return sen.next;
	}
	public static ListNode reverse(ListNode head) {
		if(head.next == null || head == null) return head;
		ListNode second = head.next;
		head.next=null;
		ListNode reversed = reverse(second);
		second.next = head;
		return reversed;
	}
