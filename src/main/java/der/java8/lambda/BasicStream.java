package der.java8.lambda;

import java.util.List;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
/**
* @FileName:BasicStream
* @Description:
* @Author: Derrick Ye
*/
public class BasicStream {

    public static List<String> getLowPriceBooknames(List<Book> books){
        return books.stream()
                .filter(book -> book.getBookprice()<50)
                .sorted(comparing(Book::getBookprice))
                .map(Book::getBookname)
                .collect(toList());
    }
}
