public class NotFoundResponse implements Response {
    @Override
    public void doResponse(Request request) {
        System.out.println("###### response:NotFoundResponse #####");
        System.out.println("존재하지 않는 페이지");
    }
}
