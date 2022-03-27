<script>

    import {onMount} from "svelte";
    import {writable} from "svelte/store";

    let apiData = writable([])

    function getBooks() {
        fetch("/api/books")
            .then(response => response.json())
            .then(data => {
                apiData.set(data);
            })
            .catch(error => {
                console.log(error);
                return [];
            });
    }

    onMount(async () => {
        getBooks();
    });
</script>

<main>
    {#each $apiData as book}
        <li>{book.title}</li>
    {/each}
</main>

<style>
    main {
        text-align: center;
        padding: 1em;
        max-width: 240px;
        margin: 0 auto;
    }

    h1 {
        color: #ff3e00;
        text-transform: uppercase;
        font-size: 4em;
        font-weight: 100;
    }

    @media (min-width: 640px) {
        main {
            max-width: none;
        }
    }
</style>