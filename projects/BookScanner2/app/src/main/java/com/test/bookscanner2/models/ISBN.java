package com.test.bookscanner2.models;

/**
 * Created by audreyeso on 8/6/16.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ISBN {

    @SerializedName("publishers")
    @Expose
    private List<Publisher> publishers = new ArrayList<Publisher>();
    @SerializedName("pagination")
    @Expose
    private String pagination;
    @SerializedName("identifiers")
    @Expose
    private Identifiers identifiers;
    @SerializedName("table_of_contents")
    @Expose
    private List<TableOfContent> tableOfContents = new ArrayList<TableOfContent>();
    @SerializedName("links")
    @Expose
    private List<Link> links = new ArrayList<Link>();
    @SerializedName("weight")
    @Expose
    private String weight;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("classifications")
    @Expose
    private Classifications classifications;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("number_of_pages")
    @Expose
    private Integer numberOfPages;
    @SerializedName("cover")
    @Expose
    private Cover cover;
    @SerializedName("subjects")
    @Expose
    private List<Subject> subjects = new ArrayList<Subject>();
    @SerializedName("publish_date")
    @Expose
    private String publishDate;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("authors")
    @Expose
    private List<Author> authors = new ArrayList<Author>();
    @SerializedName("by_statement")
    @Expose
    private String byStatement;
    @SerializedName("publish_places")
    @Expose
    private List<PublishPlace> publishPlaces = new ArrayList<PublishPlace>();
    @SerializedName("ebooks")
    @Expose
    private List<Ebook> ebooks = new ArrayList<Ebook>();

    /**
     *
     * @return
     * The publishers
     */
    public List<Publisher> getPublishers() {
        return publishers;
    }

    /**
     *
     * @param publishers
     * The publishers
     */
    public void setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
    }

    /**
     *
     * @return
     * The pagination
     */
    public String getPagination() {
        return pagination;
    }

    /**
     *
     * @param pagination
     * The pagination
     */
    public void setPagination(String pagination) {
        this.pagination = pagination;
    }

    /**
     *
     * @return
     * The identifiers
     */
    public Identifiers getIdentifiers() {
        return identifiers;
    }

    /**
     *
     * @param identifiers
     * The identifiers
     */
    public void setIdentifiers(Identifiers identifiers) {
        this.identifiers = identifiers;
    }

    /**
     *
     * @return
     * The tableOfContents
     */
    public List<TableOfContent> getTableOfContents() {
        return tableOfContents;
    }

    /**
     *
     * @param tableOfContents
     * The table_of_contents
     */
    public void setTableOfContents(List<TableOfContent> tableOfContents) {
        this.tableOfContents = tableOfContents;
    }

    /**
     *
     * @return
     * The links
     */
    public List<Link> getLinks() {
        return links;
    }

    /**
     *
     * @param links
     * The links
     */
    public void setLinks(List<Link> links) {
        this.links = links;
    }

    /**
     *
     * @return
     * The weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     *
     * @param weight
     * The weight
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The classifications
     */
    public Classifications getClassifications() {
        return classifications;
    }

    /**
     *
     * @param classifications
     * The classifications
     */
    public void setClassifications(Classifications classifications) {
        this.classifications = classifications;
    }

    /**
     *
     * @return
     * The notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     *
     * @param notes
     * The notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     *
     * @return
     * The numberOfPages
     */
    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    /**
     *
     * @param numberOfPages
     * The number_of_pages
     */
    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    /**
     *
     * @return
     * The cover
     */
    public Cover getCover() {
        return cover;
    }

    /**
     *
     * @param cover
     * The cover
     */
    public void setCover(Cover cover) {
        this.cover = cover;
    }

    /**
     *
     * @return
     * The subjects
     */
    public List<Subject> getSubjects() {
        return subjects;
    }

    /**
     *
     * @param subjects
     * The subjects
     */
    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    /**
     *
     * @return
     * The publishDate
     */
    public String getPublishDate() {
        return publishDate;
    }

    /**
     *
     * @param publishDate
     * The publish_date
     */
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    /**
     *
     * @return
     * The key
     */
    public String getKey() {
        return key;
    }

    /**
     *
     * @param key
     * The key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     *
     * @return
     * The authors
     */
    public List<Author> getAuthors() {
        return authors;
    }

    /**
     *
     * @param authors
     * The authors
     */
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    /**
     *
     * @return
     * The byStatement
     */
    public String getByStatement() {
        return byStatement;
    }

    /**
     *
     * @param byStatement
     * The by_statement
     */
    public void setByStatement(String byStatement) {
        this.byStatement = byStatement;
    }

    /**
     *
     * @return
     * The publishPlaces
     */
    public List<PublishPlace> getPublishPlaces() {
        return publishPlaces;
    }

    /**
     *
     * @param publishPlaces
     * The publish_places
     */
    public void setPublishPlaces(List<PublishPlace> publishPlaces) {
        this.publishPlaces = publishPlaces;
    }

    /**
     *
     * @return
     * The ebooks
     */
    public List<Ebook> getEbooks() {
        return ebooks;
    }

    /**
     *
     * @param ebooks
     * The ebooks
     */
    public void setEbooks(List<Ebook> ebooks) {
        this.ebooks = ebooks;
    }

}