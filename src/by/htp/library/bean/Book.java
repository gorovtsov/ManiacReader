package by.htp.library.bean;

public class Book {

	private int id;
	private int pagesCount;
	private int printYear;
	private int amount;
	private String title;
	private String author;
	private String publisher;
	private String genre;
	private String format;
	private String cover;

	public Book() {
		super();
	}

	public Book(String title, String author, String publisher, String genre, String format, String cover,
			int pagesCount, int printYear) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.genre = genre;
		this.format = format;
		this.cover = cover;
		this.pagesCount = pagesCount;
		this.printYear = printYear;
	}
	
	public Book(int id, String title, String author, String publisher, String genre, String format, String cover,
			int pagesCount, int printYear, int amount) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.genre = genre;
		this.format = format;
		this.cover = cover;
		this.pagesCount = pagesCount;
		this.printYear = printYear;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPagesCount() {
		return pagesCount;
	}

	public void setPagesCount(int pagesCount) {
		this.pagesCount = pagesCount;
	}

	public int getPrintYear() {
		return printYear;
	}

	public void setPrintYear(int printYear) {
		this.printYear = printYear;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((cover == null) ? 0 : cover.hashCode());
		result = prime * result + ((format == null) ? 0 : format.hashCode());
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + id;
		result = prime * result + pagesCount;
		result = prime * result + printYear;
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (amount != other.amount)
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (cover == null) {
			if (other.cover != null)
				return false;
		} else if (!cover.equals(other.cover))
			return false;
		if (format == null) {
			if (other.format != null)
				return false;
		} else if (!format.equals(other.format))
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (id != other.id)
			return false;
		if (pagesCount != other.pagesCount)
			return false;
		if (printYear != other.printYear)
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", pagesCount=" + pagesCount + ", printYear=" + printYear + ", amount=" + amount
				+ ", title=" + title + ", author=" + author + ", publisher=" + publisher + ", genre=" + genre
				+ ", format=" + format + ", cover=" + cover + "]";
	}	
}
